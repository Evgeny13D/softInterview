package A402.controller.admin_controllers.articles_action;

import A402.dao.ArticlesDao;
import A402.dao.DaoFactory;
import A402.model.Articles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kapliarchuk_Y on 25/07/2018.
 */
@WebServlet("/getArticle")
public class GetArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        String articleIdString = request.getParameter("articleId");
        int articleId = Integer.parseInt(articleIdString);

        ArticlesDao articlesDao = DaoFactory.createArticlesDao();
        articlesDao.addViews(articleId);
        Articles articles = articlesDao.getArticleById(articleId);
        Gson gson = new GsonBuilder()
                .setDateFormat("HH:mm").create();
        response.getWriter().println(gson.toJson(articles));
    }
}
