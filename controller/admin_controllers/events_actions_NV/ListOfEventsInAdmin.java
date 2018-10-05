package A402.controller.admin_controllers.events_actions_NV;

import A402.dao.daoImpl.EventDaoImpl_NV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ListOfEventsInAdmin")
public class ListOfEventsInAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("eventsList", new EventDaoImpl_NV().listOfEventsJust());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin1.jsp").forward(request, response);
    }
}
