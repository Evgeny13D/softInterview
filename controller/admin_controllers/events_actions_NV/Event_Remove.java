package A402.controller.admin_controllers.events_actions_NV;

import A402.dao.ArticlesDao;
import A402.dao.DaoFactory;
import A402.dao.EventDao_NV;
import A402.dao.daoImpl.EventDaoImpl_NV;
import A402.model.Articles;
import A402.model.Event_NV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet(name = "Event_Remove")
public class Event_Remove extends HttpServlet {
    private EventDaoImpl_NV eventDaoImpl_nv = new EventDaoImpl_NV();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);

//        EventDao_NV eventDao = DaoFactory.createEventDao_NV();
//        Event_NV event_nv = eventDao.getEventByIdJustForRemove(id);
//        try{
//            File file = new File("/opt/tomcat/images/" + event_nv.getLinkOfImage());
////        File file = new File("/Users/evgeny/Downloads/" + event_nv.getLinkOfImage());
////            file.delete();
//            if(file.delete()){
//                System.out.println(file.getName() + " is deleted");
//            } else {
//                System.out.println("Delete operation is failed!");
//            }
//        } catch (Exception e){
//
//        }
        EventDao_NV eventDao_nv = DaoFactory.createEventDao_NV();
        Event_NV event_nv = eventDao_nv.getEventByIdJustForRemove(id);
        try{
            Files.delete( new File("/opt/tomcat/images/" + event_nv.getLinkOfImage()).toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
//        new File("/opt/tomcat/images/" + event_nv.getLinkOfImage()).delete();
        eventDao_nv.deleteEvent(id);

//        eventDao.deleteEvent(id);

//        request.setAttribute("eventsList", new EventDaoImpl_NV().listOfEventsJust());
//        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin1.jsp").forward(request, response);
        response.sendRedirect("/ListOfEventsInAdmin");
    }
}
