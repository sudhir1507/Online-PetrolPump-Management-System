package org.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.petrolpump.admin.model.EmployeeModel;
import org.petrolpump.admin.service.EmployeeService;
import org.petrolpump.admin.service.EmployeeServiceImpl;


@WebServlet("/addemployee")
public class AddNewEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		int sal=Integer.parseInt(request.getParameter("sal"));
		EmployeeModel empModel=new EmployeeModel();
		empModel.setName(name);
		empModel.setEmail(email);
		empModel.setContact(contact);
		empModel.setAddress(address);
		empModel.setSal(sal);
		EmployeeService empService=new EmployeeServiceImpl();
		boolean b=empService.isAddNewEmployee(empModel);
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("admindashbord.jsp");
			r.include(request, response);
			out.println("<h1>Employee Added Successfully...<h1>");
		}else {
			RequestDispatcher r=request.getRequestDispatcher("admindashbord.jsp");
			r.include(request, response);
			out.println("<h1>Employee Not Added Successfully...<h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
