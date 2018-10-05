package A402.controller.admin_controllers.events_actions_NV.manageOfEvents;

import A402.dao.daoImpl.EventDaoImpl_NV;
import A402.model.Event_NV;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Manage_EditEvent")
@MultipartConfig
public class Manage_EditEvent extends HttpServlet {
    private EventDaoImpl_NV eventDaoImpl_nv = new EventDaoImpl_NV();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Event_NV event_nv = new Event_NV();

        event_nv.setNameRu(request.getParameter("ru_title"));
        event_nv.setStatus(request.getParameter("optionSelect"));

        int id = Integer.parseInt(request.getParameter("id"));

        eventDaoImpl_nv.editManageEvent(id, event_nv);

        request.setAttribute("eventsList", new EventDaoImpl_NV().listOfEventsJust());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin1.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
