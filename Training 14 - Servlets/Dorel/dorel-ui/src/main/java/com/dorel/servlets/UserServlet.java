package com.dorel.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dorel.db.manager.HSQLDBManager;
import com.dorel.dto.User;

/**
 * The UserServlet.java.
 * @author dungureanu
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3553124310749435624L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final User user = new User();

		final int userId = Integer.parseInt(request.getParameter("id"));
		boolean userFound = false;

		ResultSet rs;
		try {
			rs = getDBManager(request).getConnection().prepareStatement("select * from USERS where USER_ID='" + userId + "';")
					.executeQuery();

			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUser(rs.getString(2));
				user.setPass(rs.getString(3));

				userFound = true;
			}
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("user", user);
		request.setAttribute("userFound", userFound);
		request.getRequestDispatcher("/User.jsp").forward(request, response);
	}

	@Override
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final User user = new User();

		user.setId(Integer.parseInt(request.getParameter("userId")));
		user.setUser(request.getParameter("userName"));
		user.setPass(request.getParameter("userPass"));
		boolean userFound = true;

		PreparedStatement ps;
		try {
			ps = getDBManager(request).getConnection().prepareStatement("update USERS set USER_NAME = ?, USER_PASS = ? where USER_ID = ?;");

			ps.setString(1, user.getUser());
			ps.setString(2, user.getPass());
			ps.setInt(3, user.getId());

			ps.executeUpdate();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			userFound = false;
		}

		request.setAttribute("user", user);
		request.setAttribute("userFound", userFound);
		request.getRequestDispatcher("/User.jsp").forward(request, response);
	}

	/**
	 * Gets the DB manager.
	 * @param request the request
	 * @return the DB manager
	 */
	private HSQLDBManager getDBManager(final HttpServletRequest request) {

		final ServletContext ctx = request.getServletContext();
		final HSQLDBManager dbManager = (HSQLDBManager) ctx.getAttribute("HSQLDBManager");
		return dbManager;

	}
}
