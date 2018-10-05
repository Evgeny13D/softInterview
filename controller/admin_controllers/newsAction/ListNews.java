package A402.controller.admin_controllers.newsAction;

import A402.dao.daoImpl.DaoAdminImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListNews")
public class ListNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin4.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("newsList", new DaoAdminImpl().listOfNews());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin4.jsp").forward(request, response);
    }
}
