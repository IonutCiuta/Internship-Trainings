package com.dorel.filters;

import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * The LoggingFilter.java.
 * @author dungureanu
 */
@WebFilter("/*")
public class LoggingFilter implements Filter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws java.io.IOException,
			ServletException {
		// Get the IP address of client machine.
		final String ipAddress = request.getRemoteAddr();
		// Log the IP address and current timestamp.
		System.out.println("IP " + ipAddress + ", Time " + new Date().toString());
		// Pass request back down the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}