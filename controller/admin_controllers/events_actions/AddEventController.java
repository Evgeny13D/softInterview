package A402.controller.admin_controllers.events_actions;

import A402.controller.exception.InvalidParameterException;
import A402.controller.utils.RequestParametersConverter;
import A402.dao.DaoFactory;
import A402.dao.EventDao;
import A402.dao.SeatDao;
import A402.model.Event;
import A402.model.Seat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addEvent")
public class AddEventController extends HttpServlet {

    private static final int DEFAULT_ROW_NUMBER = 3;
    private static final int DEFAULT_SEAT_NUMBER = 7;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        String priceString = request.getParameter("price");
        if (priceString.isEmpty()) {
            throw new InvalidParameterException("Price cannot be empty");
        }
        double price = 0.0;
        try {
            price = Double.parseDouble(priceString);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Price must be a numeric value", e);
        }
        Event event = RequestParametersConverter.convertToEvent(parameters);
        event.setPrice(price);
        EventDao eventDao = DaoFactory.createEventDao();
        eventDao.storeEvent(event);

        SeatDao seatDao = DaoFactory.createSeatDao();
        for (int rowNumber = 1; rowNumber <= DEFAULT_ROW_NUMBER; rowNumber++) {
            for (int seatNumber = 1; seatNumber <=DEFAULT_SEAT_NUMBER; seatNumber++) {
                Seat seat = new Seat();
                seat.setRowNumber(rowNumber);
                seat.setSeatNumber(seatNumber);
                seat.setPrice(price);
                seat.setEventId(event.getId());
                seatDao.storeSeat(seat);
            }
        }

        response.sendRedirect("/editEvents");
    }
}
