package A402.controller.admin_controllers.events_actions;

import A402.controller.exception.InvalidParameterException;
import A402.controller.utils.RequestParametersConverter;
import A402.dao.DaoFactory;
import A402.dao.EventDao;
import A402.model.Event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/updateEvent")
public class UpdateEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("eventId");
        int id = Integer.parseInt(idString);
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
        event.setId(id);
        event.setPrice(price);
        EventDao eventDao = DaoFactory.createEventDao();
        eventDao.updateEvent(event);

        response.sendRedirect("/editEvents");
    }
}
