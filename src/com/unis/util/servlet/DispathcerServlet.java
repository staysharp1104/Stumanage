package com.unis.util.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DispathcerServlet extends HttpServlet {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		String path = "/pages/errors.jsp";
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		if(status != null) {
			try {
				Method method = this.getClass().getMethod(status);
				path = (String)method.invoke(this);
				System.out.println("status:"+status+"  method:"+method+"  path:"+path);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			request.getRequestDispatcher(path).forward(request, response);
		}catch (Exception e) {}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
