package org.petrolpump.employee.controller;

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


@WebServlet("/updateprofile")
public class ProfileUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("s");
		if(btn!=null) {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			String address=request.getParameter("address");
			int salary=Integer.parseInt(request.getParameter("salary"));
			EmployeeModel model=new EmployeeModel();
			model.setId(id);
			model.setName(name);
			model.setEmail(email);
			model.setContact(contact);
			model.setAddress(address);
			model.setSal(salary);
			EmployeeService employeeService=new EmployeeServiceImpl();
			boolean b=employeeService.updateprofile(model);
			if(b) {
				RequestDispatcher r=request.getRequestDispatcher("viewprofile.jsp");
				r.forward(request, response);
			}else {
				out.println("some problem is there to update profile..!");
			}
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
