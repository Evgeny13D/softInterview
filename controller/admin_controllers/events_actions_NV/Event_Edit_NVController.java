package A402.controller.admin_controllers.events_actions_NV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kapliarchuk_Y on 08/08/2018.
 */
@WebServlet("/Event_Edit_NVController")
public class Event_Edit_NVController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/Event_Edit_NV.jsp").forward(request, response);
    }
}
