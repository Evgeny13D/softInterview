package A402.email;


import A402.controller.exception.InvalidParameterException;
import A402.dao.DaoFactory;
import A402.dao.EventDao_NV;
import A402.dao.SubscribeDao;
import A402.model.Event_NV;
import A402.model.Subscribe;
import freemarker.template.Configuration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("/sendSubscription")
public class SendSubscriptionController extends HttpServlet {

    private TrashEmailFilter trashEmailFilter;
    private EmailSender emailSender;

    private String trashEmailKeywordsPath = "/A402/email/configs/trash_email_keywords.csv";

    //    @Resource(name = "mailTemplatePath")
    private String templatePath = "/A402/email/templates/";

    //    @Resource(name = "unsubscribeUrl")
    private String unsubscribeUrl = "a402.by/unsubscribe";

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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventId = req.getParameter("eventId");
        if (eventId == null) throw new InvalidParameterException("Event id cannot be empty");
        int newEventId = Integer.parseInt(eventId);

        EventDao_NV eventDao_nv = DaoFactory.createEventDao_NV();
        Event_NV newEvent = eventDao_nv.getEventById(newEventId);
        if (newEvent == null) throw new InvalidParameterException("Not existed event with id=" + newEventId);


        SubscribeDao subscribeDao = DaoFactory.createSubscribeDao();
        Set<String> subscribedEmails = subscribeDao.listOfSubscribes().stream().map(Subscribe::getEmail).collect(Collectors.toSet());

        HashSet<String> alreadySentEmails = new HashSet<>();
        for (String e : subscribedEmails) {
            if (alreadySentEmails.add(e)) {
                if (trashEmailFilter.isEmailTrash(e)) continue;
                emailSender.sendEmailAboutNewEvents(newEvent, e);
            }
        }
    }

}
