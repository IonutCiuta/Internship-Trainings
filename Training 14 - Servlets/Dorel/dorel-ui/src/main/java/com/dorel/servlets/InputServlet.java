/**
 * The InputServlet.java
 * @autor dungureanu
 */
package com.dorel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The InputServlet.java.
 * @author dungureanu
 */
@WebServlet("/input-method")
public class InputServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2502627240396257080L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Name: " + request.getParameter("name"));
		System.out.println("Password: " + request.getParameter("pass"));
		System.out.println("Gender: " + request.getParameter("gender"));
		System.out.println("Country: " + request.getParameter("countryCode"));
		System.out.println("Animal: " + request.getParameter("animalId"));
		System.out.println("Message: " + request.getParameter("message"));

		request.getRequestDispatcher("/input").forward(request, response);
	}

}