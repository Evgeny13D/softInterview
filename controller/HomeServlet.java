package A402.controller;


import A402.dao.daoImpl.DaoAdminImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json");
        DaoAdminImpl daoAdmin = new DaoAdminImpl();
        request.setAttribute("newsList", daoAdmin.listOfNewsShow());
//
//        DaoAdminImpl daoAdmin = new DaoAdminImpl();
//
//        List<News> list = new DaoAdminImpl().listOfNewsShow();
//        Gson gson = new Gson();
//        response.getWriter().println(gson.toJson(list));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
