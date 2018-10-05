package A402.controller.admin_controllers.manageOfArticles;

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

@WebServlet("/Manage_ListArticles")
public class Manage_ListArticles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");// Will save Json on page in browser, not html

        ArticlesDao itemDao = DaoFactory.createArticlesDao();
        List<Articles> items = itemDao.listManageArticles();
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(items));
    }
}
