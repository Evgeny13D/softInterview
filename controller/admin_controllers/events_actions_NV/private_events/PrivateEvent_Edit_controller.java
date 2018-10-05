package A402.controller.admin_controllers.events_actions_NV.private_events;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kapliarchuk_Y on 17/08/2018.
 */
@WebServlet("/PrivateEvent_Edit_controller")
public class PrivateEvent_Edit_controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/PrivateEvent_Edit.jsp").forward(request, response);
    }
}
