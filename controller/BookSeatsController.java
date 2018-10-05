package A402.controller;

import A402.controller.exception.InvalidParameterException;
import A402.controller.utils.RequestParametersConverter;
import A402.dao.DaoException;
import A402.dao.DaoFactory;
import A402.dao.EventDao_NV;
import A402.dao.ParticipantDao;
import A402.email.EmailSender;
import A402.email.EmailTemplateConfig;
import A402.email.TrashEmailFilter;
import A402.model.BookingStatus;
import A402.model.Event_NV;
import A402.model.Participant;
import freemarker.template.Configuration;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/bookSeats")
public class BookSeatsController extends HttpServlet {

//    @Resource(name = "trashEmailKeywordsPath")
    private String trashEmailKeywordsPath = "/A402/email/configs/trash_email_keywords.csv";

//    @Resource(name = "mailTemplatePath")
    private String templatePath = "/A402/email/templates/";

//    @Resource(name = "unsubscribeUrl")
    private String unsubscribeUrl = "a402.by/unsubscribe";

    private TrashEmailFilter trashEmailFilter;
    private EmailSender emailSender;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            trashEmailFilter = new TrashEmailFilter(trashEmailKeywordsPath);
            Configuration configuration = EmailTemplateConfig.init(templatePath);
            emailSender = new EmailSender(configuration, unsubscribeUrl);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        String[] seats = parameters.get("seats");
        if (seats != null && seats.length == 1) {
            Participant p = RequestParametersConverter.convertToParticipant(parameters);
            EventDao_NV eventDao_nv = DaoFactory.createEventDao_NV();

            Event_NV eventById = eventDao_nv.getEventById(p.getEventId());

            double totalPrice = 0;
            for (String seatCode : seats[0].split("-")) {
                int participantId = eventById.getSeat(seatCode);

                if (participantId == 0) { // not booked
                    totalPrice += eventById.getSeatPrice(seatCode);
                } else {
                    throw new DaoException(String.format("Already booked seat %s", seatCode));
                }
            }
            p.setTotal_price(totalPrice);
            p.setBookingStatus(BookingStatus.BOOKED);

            ParticipantDao participantDao = DaoFactory.createParticipantDao();
            p = participantDao.storeParticipant(p);

            for (String seatCode : seats[0].split("-")) {
                int participantId = eventById.getSeat(seatCode);

                if (participantId == 0) { // not booked
                    eventById.setSeat(seatCode, p.getId());
                } else {
                    throw new DaoException(String.format("Already booked seat %s", seatCode));
                }
            }

            eventDao_nv.updateEvent(eventById);

            emailSender.sendRegistrationEmail(p, eventById);

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            throw new InvalidParameterException("Request has no seats parameter");
        }
    }
}
