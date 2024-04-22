package org.petrolpump.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.petrolpump.admin.service.EmployeeService;
import org.petrolpump.admin.service.EmployeeServiceImpl;


@WebServlet("/validate")
public class EmployeeValidateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("email");
		String password=request.getParameter("contact");
		EmployeeService eService=new EmployeeServiceImpl();
		int result=eService.verifyEmployee(username, password);
		if(result!=0) {
			HttpSession session=request.getSession(true);
			session.setAttribute("employeeId", result);
			RequestDispatcher r=request.getRequestDispatcher("employeedashboard.jsp");
			r.forward(request, response);
		}else {
			out.println("<h1>Invalid Username or Password</h1>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
