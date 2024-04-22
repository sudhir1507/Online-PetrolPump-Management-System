package org.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.petrolpump.admin.service.EmployeeService;
import org.petrolpump.admin.service.EmployeeServiceImpl;

@WebServlet("/finalmachineallocate")
public class FinalMachineAllocateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int empId=Integer.parseInt(request.getParameter("empId"));
		int mid=Integer.parseInt(request.getParameter("mid"));
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String date=request.getParameter("allDate");
		out.println(empId+"\t"+mid+"\t"+startTime+"\t"+endTime+"\t"+date);
		EmployeeService empService=new EmployeeServiceImpl();
		boolean b=empService.allocateMachine(empId,mid,startTime,endTime,date);
		if(b) {
			out.println("<h1>Machine Allocated Successfully..</h1>");
		}else {
			out.println("<h1>Machine Not Allocated Successfully..</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
