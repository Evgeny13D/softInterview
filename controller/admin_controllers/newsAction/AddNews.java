package A402.controller.admin_controllers.newsAction;

import A402.dao.daoImpl.DaoAdminImpl;
import A402.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddNews")
public class AddNews extends HttpServlet {
    private DaoAdminImpl addNewNews = new DaoAdminImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        News news = new News();
        news.setRu_title(request.getParameter("ru_title"));
        news.setRu_description(request.getParameter("ru_description"));
        news.setRu_info(request.getParameter("ru_info"));
        news.setEn_title(request.getParameter("en_title"));
        news.setEn_description(request.getParameter("en_description"));
        news.setEn_info(request.getParameter("en_info"));
        news.setStatus(request.getParameter("optionSelect"));
        news.setAdded(String.valueOf(new Date()));

        addNewNews.addNewNews(news);

        request.setAttribute("newsList", new DaoAdminImpl().listOfNews());
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin4.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin4.jsp").forward(request, response);
    }
}
