package com.dorel.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The HelloWorldServlet.java.
 * @author dungureanu
 */
public class HelloWorldServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4212136312647628090L;
	private String message;

	@Override
	public void init() throws ServletException {
		// Do required initialization
		message = "Hello World";
	}

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		final PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
		out.print("<input type=\"submit\" value=\"Home\" onclick=\"window.location='/dorel-ui';\" /> ");
		out.close();
	}

	@Override
	public void destroy() {
		// do nothing.
	}
}