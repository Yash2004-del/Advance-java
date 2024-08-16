package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NameTypeServlet")
public class NameTypeServlet extends HttpServlet{
	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException
	{
		
		String Firstname = request.getParameter("firstname");
		String UpperCase = "UpperCase";  
		String LowerCase = "LowerCase";
		String reverse = "";
		String type = request.getParameter("type");
		
		PrintWriter out = response.getWriter();
		
		if(type.equals(UpperCase))
		{
			out.println("Uppercase is "+Firstname.toUpperCase());
		}
		else if(type.equals(LowerCase))
		{
			out.println("Lowercase is "+Firstname.toLowerCase());
		}
		else
		{
			for(Integer i=0 ; i<Firstname.length() ; i++)
			{
				reverse = Firstname.charAt(i)+ reverse;
			}
			out.println("Reversed String is "+reverse);
		}
		
	}
	
}
