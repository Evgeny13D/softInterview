package A402.controller;

import A402.dao.DaoFactory;
import A402.dao.EventDao;
import A402.model.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getEvent")
public class GetEventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        String eventIdString = request.getParameter("eventId");
        int articleId = Integer.parseInt(eventIdString);

        EventDao eventDao = DaoFactory.createEventDao();
        Event event = eventDao.getEventById(articleId);
        Gson gson = new GsonBuilder()
                .setDateFormat("HH:mm").create();
        response.getWriter().println(gson.toJson(event));
//        request.setAttribute("event", event);
    }
}
