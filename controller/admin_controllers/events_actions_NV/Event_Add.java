package A402.controller.admin_controllers.events_actions_NV;

import A402.controller.utils.RequestParametersConverter;
import A402.dao.DaoFactory;
import A402.dao.EventDao_NV;
import A402.dao.daoImpl.EventDaoImpl_NV;
import A402.model.Articles;
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
 * Created by Kapliarchuk_Y on 08/08/2018.
 */
@WebServlet("/Event_Add")
@MultipartConfig
public class Event_Add extends HttpServlet {
    private EventDaoImpl_NV eventDaoImpl_nv = new EventDaoImpl_NV();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        String priceString = request.getParameter("price");
        String priceS16 = request.getParameter("priceS16");
        String priceS14 = request.getParameter("priceS14");

        Event_NV event_nv = RequestParametersConverter.convertToEvent_NV(parameters);
        if (priceString.isEmpty() && priceS16.isEmpty() ) {
            event_nv.setType("free");
            event_nv.setStatus("show");
        } else if(priceS16.equals(priceS14)){
            event_nv.setPrice(Double.valueOf(priceString));
            event_nv.setPriceS16(Double.valueOf(priceS16));
            event_nv.setPriceS712(Double.valueOf(request.getParameter("priceS712")));
            event_nv.setPriceS13(Double.valueOf(request.getParameter("priceS13")));
            event_nv.setPriceS14(Double.valueOf(request.getParameter("priceS14")));
            event_nv.setType("alike");
            event_nv.setStatus("show");

        } else if(priceString.isEmpty() && !(priceS16.isEmpty())){
            event_nv.setPriceS16(Double.valueOf(priceS16));
            event_nv.setPriceS712(Double.valueOf(request.getParameter("priceS712")));
            event_nv.setPriceS13(Double.valueOf(request.getParameter("priceS13")));
            event_nv.setPriceS14(Double.valueOf(request.getParameter("priceS14")));
            event_nv.setType("Deference");
            event_nv.setStatus("show");
        }

        Part filePart = request.getPart("link_ofImage");
        String check = getSubmittedFileName(filePart);

        if(check.equals("")){
            event_nv.setLinkOfImage("no_image");
            eventDaoImpl_nv.storeEvent(event_nv);
        }else {

            String link = "A402-" + System.currentTimeMillis() + ".jpg";
            File uploads = new File("/opt/tomcat/images");
            File file = new File(uploads, link);
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath());
            }
            event_nv.setLinkOfImage(link);
            eventDaoImpl_nv.storeEvent(event_nv);
        }


//        request.setAttribute("eventsList", new EventDaoImpl_NV().listOfEvents());
//        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin1.jsp").forward(request, response);
        response.sendRedirect("/ListOfEventsInAdmin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
