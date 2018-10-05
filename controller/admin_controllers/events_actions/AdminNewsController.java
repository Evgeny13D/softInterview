package A402.controller.admin_controllers.events_actions;

import A402.dao.daoImpl.DaoAdminImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminNewsController")
public class AdminNewsController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoAdminImpl daoAdmin = new DaoAdminImpl();
        request.setAttribute("newsList", daoAdmin.listOfNews());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin4.jsp").forward(request, response);
    }
}
