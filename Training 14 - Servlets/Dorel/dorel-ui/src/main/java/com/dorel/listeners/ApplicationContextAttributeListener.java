package com.dorel.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * The ApplicationContextAttributeListener.java.
 * @author dungureanu
 */
@WebListener
public class ApplicationContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(final ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("ServletContext attribute added " + servletContextAttributeEvent.getName() + ","
				+ servletContextAttributeEvent.getValue());
	}

	@Override
	public void attributeReplaced(final ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("ServletContext attribute replaced " + servletContextAttributeEvent.getName() + ","
				+ servletContextAttributeEvent.getValue());
	}

	@Override
	public void attributeRemoved(final ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("ServletContext attribute removed " + servletContextAttributeEvent.getName() + ","
				+ servletContextAttributeEvent.getValue());
	}

}