package A402.controller;

import A402.dao.daoImpl.EventDaoImpl_NV;

import java.io.IOException;

public class AdminController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String email    = request.getParameter("email");
        String password = request.getParameter("password");

        if(email.equals("admin") && password.equals("adminArt")){
            request.setAttribute("eventsList", new EventDaoImpl_NV().listOfEventsJust());
            request.getRequestDispatcher("WEB-INF/pages/indexOfAdmin1.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("WEB-INF/pages/loginOfAdmin.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/loginOfAdmin.jsp").forward(request, response);
    }
}
