package com.dorel.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The HSQLDBManager.java.
 * @author dungureanu
 */
public class HSQLDBManager {

	private Connection connection;

	public HSQLDBManager(final String className, final String url, final String user, final String pass) {
		createConnection(className, url, user, pass);
	}

	private void createConnection(final String className, final String url, final String user, final String pass) {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() {
		// do something
	}

}
