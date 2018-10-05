package A402.controller;

import A402.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Evgeny on 4/7/17.
 */
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        String url = httpServletRequest.getRequestURI();
        if (user != null
                ||url.equals("/")
                ||url.endsWith(".js")
                ||url.endsWith(".css")
                ||url.endsWith(".jsp") ||url.endsWith(".jpg") || url.endsWith("AuthController")
                ) {
            chain.doFilter(req, resp);
        } else {
            httpServletResponse.sendRedirect("index.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
