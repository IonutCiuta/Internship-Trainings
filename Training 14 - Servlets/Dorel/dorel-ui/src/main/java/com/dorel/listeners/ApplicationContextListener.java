package com.dorel.listeners;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dorel.db.manager.HSQLDBManager;

/**
 * The ApplicationContextListener.java.
 * @author dungureanu
 */
@WebListener
public class ApplicationContextListener implements ServletContextListener {

	private final static ResourceBundle BUNDLE = ResourceBundle.getBundle("resourceBundle");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void contextInitialized(final ServletContextEvent servletContextEvent) {
		final ServletContext ctx = servletContextEvent.getServletContext();

		final String className = BUNDLE.getString("hsqldb.class");
		final String url = BUNDLE.getString("hsqldb.url");
		final String user = BUNDLE.getString("hsqldb.user");
		final String pass = BUNDLE.getString("hsqldb.pass");

		// create database connection from init parameters and set it to context
		final HSQLDBManager dbManager = new HSQLDBManager(className, url, user, pass);
		ctx.setAttribute("HSQLDBManager", dbManager);

		System.out.println("Database connection initialized for Application.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void contextDestroyed(final ServletContextEvent servletContextEvent) {
		final ServletContext ctx = servletContextEvent.getServletContext();
		final HSQLDBManager dbManager = (HSQLDBManager) ctx.getAttribute("HSQLDBManager");
		dbManager.closeConnection();

		System.out.println("Database connection closed for Application.");
	}
}