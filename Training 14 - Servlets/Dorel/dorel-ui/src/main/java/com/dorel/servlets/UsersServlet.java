package com.dorel.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dorel.db.manager.HSQLDBManager;
import com.dorel.dto.User;

/**
 * The UsersServlet.java.
 * @author dungureanu
 */
@WebServlet("/users-method")
public class UsersServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2866550491239253919L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("userList", getUsers(request));

		request.getRequestDispatcher("/users").forward(request, response);
	}

	/**
	 * Gets the users.
	 * @param request the request
	 * @return the users
	 */
	private List<User> getUsers(final HttpServletRequest request) {
		final List<User> userList = new ArrayList<User>();

		final ServletContext ctx = request.getServletContext();
		final HSQLDBManager dbManager = (HSQLDBManager) ctx.getAttribute("HSQLDBManager");

		ResultSet rs;
		try {
			rs = dbManager.getConnection().prepareStatement("select * from USERS;").executeQuery();

			while (rs.next()) {
				final User user = new User();
				user.setId(rs.getInt(1));
				user.setUser(rs.getString(2));
				user.setPass(rs.getString(3));

				userList.add(user);
			}
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;

	}

}