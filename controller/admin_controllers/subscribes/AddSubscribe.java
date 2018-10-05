package A402.controller.admin_controllers.subscribes;

import A402.dao.daoImpl.SubscribeDaoIml;
import A402.model.Subscribe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kapliarchuk_Y on 06/08/2018.
 */
@WebServlet(name = "AddSubscribe")
public class AddSubscribe extends HttpServlet {
    private SubscribeDaoIml subscribeDaoIml = new SubscribeDaoIml();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Subscribe subscribe = new Subscribe();

        String email = request.getParameter("email");

        subscribe = subscribeDaoIml.getSubscriberByEmail(request.getParameter("email"));
        if(email.equals(subscribe.getEmail())){
            request.setAttribute("errorAddSubscribe", "This subscribe in Site");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else {
            subscribe.setEmail(email);
            subscribeDaoIml.addSubscribe(subscribe);
            request.getRequestDispatcher("WEB-INF/pages/indexSubscribe.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
