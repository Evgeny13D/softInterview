package A402.controller.admin_controllers.newsAction;

import A402.dao.DaoAdmin;
import A402.dao.DaoFactory;
import A402.model.News;
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
@WebServlet("/showNewsInMainPage")
public class ShowNewsInMainPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");// Will save Json on page in browser, not html

        DaoAdmin itemDao = DaoFactory.createAdminDao();
        List<News> items = itemDao.listOfNewsShow();
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(items));
    }
}
