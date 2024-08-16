package com.google.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

		public void service(HttpServletRequest request, HttpServletResponse response)
		{
			System.out.println("Helo World Good Morning");
			System.out.println("SignupServlet : service()");
		}
}
