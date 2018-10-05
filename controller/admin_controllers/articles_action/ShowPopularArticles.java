package A402.controller.admin_controllers.articles_action;

import A402.dao.ArticlesDao;
import A402.dao.DaoFactory;
import A402.model.Articles;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Kapliarchuk_Y on 27/07/2018.
 */
@WebServlet("/showPopularArticles")
public class ShowPopularArticles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");// Will save Json on page in browser, not html

        ArticlesDao itemDao = DaoFactory.createArticlesDao();
        List<Articles> items = itemDao.listPopularArticles();
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(items));
    }
}
