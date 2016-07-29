package web.listeners;

import db.PersistenceHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by iciuta on 7/28/2016.
 */
@WebListener
public class ApplicationContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context initialized");
        PersistenceHandler.init();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context destroyed");
    }
}
