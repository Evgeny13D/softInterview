package A402.controller.admin_controllers.events_actions_NV.private_events;

import A402.controller.utils.RequestParametersConverter;
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
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.Map;

import static A402.controller.utils.GetSubmittedFileName.getSubmittedFileName;

/**
 * Created by Kapliarchuk_Y on 17/08/2018.
 */
@WebServlet("/PrivateEvent_Add")
@MultipartConfig
public class PrivateEvent_Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String, String[]> parameters = request.getParameterMap();
//        Event_NV event_nv = RequestParametersConverter.convertToEvent_NV(parameters);
//        handleRequest(request, response);

        Event_NV event_nv = new Event_NV();
//        handleRequest(request, response);
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

        Part filePart = request.getPart("link_ofImage");
        String check = getSubmittedFileName(filePart);

        if(check.equals("")){
            event_nv.setLinkOfImage("no_image");
        }else {

            String link = "A402-" + System.currentTimeMillis() + ".jpg";
            File uploads = new File("/opt/tomcat/images");
            File file = new File(uploads, link);
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath());
            }
            event_nv.setLinkOfImage(link);
        }

        EventDao_NV eventDao = DaoFactory.createEventDao_NV();
        eventDao.addPrivateEvent(event_nv);

        request.setAttribute("eventsList", new EventDaoImpl_NV().listOfEventsJust());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin1.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


//    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        PrintWriter out = res.getWriter();
//
//        res.setContentType("text/plain");
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String paramName = parameterNames.nextElement();
//
//            out.write(paramName);
//
//            out.write("n");
//
//            String[] paramValues = req.getParameterValues(paramName);
//            for (int i = 0; i < paramValues.length; i++) {
//                String paramValue = paramValues[i];
//                out.write("t" + paramValue);
//                out.write("n");
//            }
//        }
//        out.close();
//    }
}
