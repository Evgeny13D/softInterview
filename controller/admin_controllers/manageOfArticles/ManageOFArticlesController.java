package A402.controller.admin_controllers.manageOfArticles;

import A402.dao.daoImpl.ArticlesDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManageOFArticlesController")
public class ManageOFArticlesController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("articlesList", new ArticlesDaoImpl().listOfArticlesJust());
        request.getRequestDispatcher("WEB-INF/pages/IndexOfManageArticlesN.jsp").forward(request, response);
    }
}
