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


@WebServlet("/finalupdate")
public class UpdateFinalEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("s");
		if(btn!=null) {
			int empid=Integer.parseInt(request.getParameter("empid"));
			String empName=request.getParameter("empName");
			String empEmail=request.getParameter("empEmail");
			String empContact=request.getParameter("empContact");
			String empAddress=request.getParameter("empAddress");
			int empSalary=Integer.parseInt(request.getParameter("empSalary"));
			EmployeeModel model=new EmployeeModel();
			model.setId(empid);
			model.setName(empName);
			model.setEmail(empEmail);
			model.setContact(empContact);
			model.setAddress(empAddress);
			model.setSal(empSalary);
			EmployeeService eService=new EmployeeServiceImpl();
			boolean b=eService.updateEmployeeById(model);
			if(b) {
				RequestDispatcher r=request.getRequestDispatcher("viewemployee.jsp");
				r.forward(request, response);
			}
		}else {
			out.println("<h1>Some problem is there</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
