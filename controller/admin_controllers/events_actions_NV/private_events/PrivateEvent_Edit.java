package A402.controller.admin_controllers.events_actions_NV.private_events;

import A402.dao.DaoFactory;
import A402.dao.EventDao_NV;
import A402.dao.daoImpl.EventDaoImpl_NV;
import A402.model.Event_NV;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Map;

import static A402.controller.utils.GetSubmittedFileName.getSubmittedFileName;

/**
 * Created by Kapliarchuk_Y on 17/08/2018.
 */
@WebServlet("/PrivateEvent_Edit")
@MultipartConfig
public class PrivateEvent_Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();


        Event_NV event_nv = new Event_NV();
        event_nv.setNameRu(request.getParameter("name_ru"));
        event_nv.setNameEn(request.getParameter("name_en"));
        event_nv.setDescriptionRu(request.getParameter("description_ru"));
        event_nv.setDescriptionEn(request.getParameter("description_en"));
        event_nv.setLocationRu(request.getParameter("location_ru"));
        event_nv.setLocationEn(request.getParameter("location_en"));
        event_nv.setAddressRu(request.getParameter("address_ru"));
        event_nv.setAddressEn(request.getParameter("address_en"));
        event_nv.setDayOfMonth(Integer.valueOf(request.getParameter("day_of_month")));
        event_nv.setMonthNumber(Integer.valueOf(request.getParameter("month_number")));
        event_nv.setDayOfWeekNumber(Integer.valueOf(request.getParameter("day_of_week_number")));
        event_nv.setYear(Integer.valueOf(request.getParameter("year")));
        event_nv.setStatus("show");
        event_nv.setType("private");

        event_nv.setId(Integer.valueOf(request.getParameter("eventId")));

        Part filePart = request.getPart("link_ofImage");
        String check = getSubmittedFileName(filePart);
        String originalNameOfLinkOfImage = request.getParameter("link_ofImageTest");

        if(check.equals("")){
            event_nv.setLinkOfImage(originalNameOfLinkOfImage);
        }else {

            String link = "A402-" + System.currentTimeMillis() + ".jpg";
            File uploads = new File("/opt/tomcat/images/" + originalNameOfLinkOfImage);
            try{
                Files.delete( uploads.toPath());
            }catch (IOException e){
                e.printStackTrace();
            }
//            uploads.delete();
            uploads = new File("/opt/tomcat/images");
            File file = new File(uploads, link);
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath());
            }
            event_nv.setLinkOfImage(link);
        }

        EventDao_NV eventDao = DaoFactory.createEventDao_NV();
        eventDao.updatePrivateEvent(event_nv);

        request.setAttribute("eventsList", new EventDaoImpl_NV().listOfEventsJust());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin1.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
