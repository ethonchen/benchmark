package com.toxind.benchmark.thrid.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.handler.AbstractHandler;

public class HelloHandler extends AbstractHandler {

	public void handle(String arg0, HttpServletRequest arg1,
			HttpServletResponse response, int arg3) throws IOException,
			ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>Hello World</h1>");
	}



}