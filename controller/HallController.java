package A402.controller;

import A402.dao.daoImpl.EventDaoImpl_NV;
import A402.model.Event_NV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/seats")
public class HallController extends HttpServlet {
    private EventDaoImpl_NV eventDao = new EventDaoImpl_NV();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("eventId"));

        Event_NV event = eventDao.getEventById(id);
        request.setAttribute("event", event);
        request.getRequestDispatcher("WEB-INF/pages/pick.jsp").forward(request, response);
    }
}
