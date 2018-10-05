package A402.controller.admin_controllers.events_actions;

import A402.dao.DaoFactory;
import A402.dao.EventDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteEvent")
public class DeleteEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);

        EventDao eventDao = DaoFactory.createEventDao();
        eventDao.deleteEvent(id);

        response.sendRedirect("/editEvents");
    }
}
