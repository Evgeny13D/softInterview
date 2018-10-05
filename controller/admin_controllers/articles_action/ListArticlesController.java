package A402.controller.admin_controllers.articles_action;

import A402.dao.daoImpl.ArticlesDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kapliarchuk_Y on 24/07/2018.
 */
@WebServlet(name = "ListArticlesController")
public class ListArticlesController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("articlesList", new ArticlesDaoImpl().listOfArticlesJust());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin2.jsp").forward(request, response);
    }
}
