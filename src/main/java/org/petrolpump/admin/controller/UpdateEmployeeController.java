package org.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateemployee")
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int empid=Integer.parseInt(request.getParameter("empid"));
		String empName=request.getParameter("empName");
		String empEmail=request.getParameter("empEmail");
		String empContact=request.getParameter("empContact");
		String empAddress=request.getParameter("empAddress");
		int empSalary=Integer.parseInt(request.getParameter("empSalary"));
		RequestDispatcher r=request.getRequestDispatcher("admindashbord.jsp");
		r.include(request, response);
		out.println("<div class='col py-3'>");
		out.println("<form class='formarea' name='frm' action='finalupdate' method='POST'>");
		out.println("<input type='hidden' name='empid' value='"+empid+"' class='control'/><br><br>");
		out.println("<input type='text' name='empName' value='"+empName+"' class='control'/><br><br>");
		out.println("<input type='text' name='empEmail' value='"+empEmail+"' class='control'/><br><br>");
		out.println("<input type='text' name='empContact' value='"+empContact+"' class='control'/><br><br>");
		out.println("<input type='text' name='empAddress' value='"+empAddress+"' class='control'/><br><br>");
		out.println("<input type='text' name='empSalary' value='"+empSalary+"' class='control'/><br><br>");
		out.println("<input type='submit' name='s' value='Update Fuel Type' class='control'/><br><br>");
		out.println("</div></div></div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
