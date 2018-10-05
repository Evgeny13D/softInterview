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
import java.util.List;

@WebServlet("/listEvents")
public class ListEventsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        EventDao eventDao = DaoFactory.createEventDao();
        List<Event> items = eventDao.listOfEvents();
        Gson gson = new GsonBuilder()
                .setDateFormat("HH:mm").create();
        response.getWriter().println(gson.toJson(items));
    }
}
