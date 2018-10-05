package A402.controller.listener;

import A402.dao.db.config.DBConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent contextEvent)  {
    }

    public void contextInitialized(ServletContextEvent contextEvent)  {
    	ServletContext context = contextEvent.getServletContext();
    	String dbConfigFilePath = context.getInitParameter("db-config-path");
    	DBConfig.defineDBConfigFilePath(dbConfigFilePath);
    }
	
}
