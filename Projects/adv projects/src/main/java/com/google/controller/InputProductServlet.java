package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputProductServlet")
public class InputProductServlet extends HttpServlet{
	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException
	{
		String ProductName = request.getParameter("ProductName");
		String Category = request.getParameter("Category");
		String Price1 = request.getParameter("Price");
		Integer Price = Integer.parseInt(Price1);
		double gstPrice = Price + Price * 0.18;
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.println("<br>ProductName : "+ProductName);
		out.println("<br>Category : "+Category);
		out.println("<br>Price : Rs "+Price);
		out.println("<br>Gst : Rs "+(Price * 0.18));
		out.println("<br>Final Price : Rs "+gstPrice);
		out.println("</body></html>");
		
	}
}
