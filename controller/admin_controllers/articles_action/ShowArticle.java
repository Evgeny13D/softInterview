package A402.controller.admin_controllers.articles_action;

import A402.dao.daoImpl.ArticlesDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kapliarchuk_Y on 25/07/2018.
 */
@WebServlet("/showArticle")
public class ShowArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("article", new ArticlesDaoImpl().getArticleById(Integer.valueOf(request.getParameter("articleId"))));
        request.getRequestDispatcher("WEB-INF/pages/post.jsp").forward(request, response);
    }
}
