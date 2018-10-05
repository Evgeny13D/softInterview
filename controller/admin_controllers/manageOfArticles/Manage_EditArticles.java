package A402.controller.admin_controllers.manageOfArticles;

import A402.dao.daoImpl.ArticlesDaoImpl;
import A402.model.Articles;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Manage_EditArticles")
@MultipartConfig
public class Manage_EditArticles extends HttpServlet {
    private ArticlesDaoImpl articlesDao = new ArticlesDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Articles articles = new Articles();

        articles.setRu_title(request.getParameter("ru_title"));
        articles.setCategory(request.getParameter("optionSelect"));

        int id = Integer.parseInt(request.getParameter("id"));

        articlesDao.editManageArticles(id, articles);

        request.setAttribute("articlesList", new ArticlesDaoImpl().listOfArticlesJust());
        request.getRequestDispatcher("WEB-INF/pages/IndexOfManageArticlesN.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
