/**
 * The ExpressionLanguageServlet.java
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
 * The ExpressionLanguageServlet.java.
 * @author dungureanu
 */
@WebServlet("/expression-language")
public class ExpressionLanguageServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2405682284457946522L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("randomAttribut", "random value");

		request.getRequestDispatcher("/ExpressionLanguage.jsp").forward(request, response);
	}

}
