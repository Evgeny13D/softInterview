package A402.controller.admin_controllers.events_actions_NV;

import A402.dao.DaoFactory;
import A402.dao.EventDao_NV;
import A402.dao.daoImpl.EventDaoImpl_NV;
import A402.model.Event_NV;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Get_Event_NV")
public class Get_Event_NV extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("event", new EventDaoImpl_NV().getEventById(Integer.valueOf(request.getParameter("eventId"))));

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        String eventIdString = request.getParameter("eventId");
        int articleId = Integer.parseInt(eventIdString);

        EventDao_NV eventDao = DaoFactory.createEventDao_NV();
        Event_NV event = eventDao.getEventById(articleId);
        Gson gson = new GsonBuilder()
                .setDateFormat("HH:mm").create();
        response.getWriter().println(gson.toJson(event));
//        request.getRequestDispatcher("WEB-INF/pages/eventNew.jsp").forward(request, response);
    }
}
