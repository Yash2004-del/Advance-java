package com.google.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	public void service (HttpServletRequest request , HttpServletResponse response)
	{
		System.out.println("LoginServlet:service()");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("Email is "+email);
		System.out.println("Password is "+password);
	}
}
