package org.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updatefuel")
public class FuelTypeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		RequestDispatcher r=request.getRequestDispatcher("admindashbord.jsp");
		r.include(request, response);
		out.println("<div class='col py-3'>");
		out.println("<form class='formarea' name='frm' action='fupdate' method='POST'>");
		out.println("<input type='hidden' name='id' value='"+id+"' class='control'/><br><br>");
		out.println("<input type='text' name='name' value='"+name+"' class='control'/><br><br>");
		out.println("<input type='submit' name='s' value='Update Fuel Type' class='control'/><br><br>");
		out.println("</div></div></div>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
