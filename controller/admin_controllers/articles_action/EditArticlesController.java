package A402.controller.admin_controllers.articles_action;

import A402.dao.daoImpl.ArticlesDaoImpl;
import A402.model.Articles;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import static A402.controller.utils.GetSubmittedFileName.getSubmittedFileName;

/**
 * Created by Kapliarchuk_Y on 25/07/2018.
 */
@WebServlet(name = "EditArticlesController")
@MultipartConfig
public class EditArticlesController extends HttpServlet {
    private ArticlesDaoImpl articlesDao = new ArticlesDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Articles articles = new Articles();

        articles.setRu_title(request.getParameter("ru_title"));
        articles.setRu_description(request.getParameter("ru_description"));
        articles.setRu_content(request.getParameter("ru_content"));
        articles.setEn_title(request.getParameter("en_title"));
        articles.setEn_description(request.getParameter("en_description"));
        articles.setEn_content(request.getParameter("en_content"));
        articles.setRu_linkAtach(request.getParameter("ru_linkAtach"));
        articles.setEn_linkAtach(request.getParameter("en_linkAtach"));
//        articles.setLink_ofImage(request.getParameter("link_ofImage"));
        articles.setCategory(request.getParameter("optionSelectArt"));

        int id = Integer.parseInt(request.getParameter("id"));

            Part filePart = request.getPart("link_ofImage");
            String check = getSubmittedFileName(filePart);
            String originalNameOfLinkOfImage = request.getParameter("link_ofImageTest");

            if(check.equals("")){
                articles.setLink_ofImage(originalNameOfLinkOfImage);
            }else {

                String link = "A402-" + System.currentTimeMillis() + ".jpg";
//                File uploads = new File("/Users/evgeny/Downloads/" + originalNameOfLinkOfImage);
                File uploads = new File("/opt/tomcat/images/" + originalNameOfLinkOfImage);
                uploads.delete();
                uploads = new File("/opt/tomcat/images");
                File file = new File(uploads, link);
                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath());
                }
                articles.setLink_ofImage(link);
            }

        articlesDao.editArticles(id, articles);

        request.setAttribute("articlesList", new ArticlesDaoImpl().listOfArticlesJust());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin2.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
