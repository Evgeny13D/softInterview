package A402.controller.admin_controllers.newsAction;

import A402.dao.daoImpl.DaoAdminImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveNews")
public class RemoveNews extends HttpServlet {
    private DaoAdminImpl daoAdmin = new DaoAdminImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        daoAdmin.removeNews(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("newsList", daoAdmin.listOfNews());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin4.jsp").forward(request, response);
    }
}
