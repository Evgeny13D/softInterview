package A402.controller.admin_controllers.articles_action;

import A402.dao.ArticlesDao;
import A402.dao.DaoFactory;
import A402.dao.daoImpl.ArticlesDaoImpl;
import A402.model.Articles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 * Created by Kapliarchuk_Y on 25/07/2018.
 */
@WebServlet(name = "RemoveArticlesController")
public class RemoveArticlesController extends HttpServlet {
    private ArticlesDaoImpl articlesDao = new ArticlesDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        String articleIdString = request.getParameter("id");
        int articleId = Integer.parseInt(articleIdString);

        ArticlesDao articlesDao = DaoFactory.createArticlesDao();
        Articles articles = articlesDao.getArticleById(articleId);
        try{
            Files.delete( new File("/opt/tomcat/images/" + articles.getLink_ofImage()).toPath());
        }catch (IOException e){
            e.printStackTrace();
        }

        articlesDao.removeArticles(articleId);
        request.setAttribute("articlesList", new ArticlesDaoImpl().listOfArticles());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin2.jsp").forward(request, response);
    }
}
