package com.dorel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The PressingButtonsServlet.java.
 * @author dungureanu
 */
@WebServlet("/pressing-buttons-method")
public class PressingButtonsServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2119074060104234824L;

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String button = request.getParameter("button");

		if ("button1".equals(button)) {
			System.out.println("Pressing button 1");
		} else if ("button2".equals(button)) {
			System.out.println("Pressing button 2");
		} else if ("button3".equals(button)) {
			System.out.println("Pressing button 3");
		} else {
			System.out.println("This is madness!!");
		}

		request.getRequestDispatcher("/pressing-buttons").forward(request, response);
	}

}