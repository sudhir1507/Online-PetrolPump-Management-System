package org.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.petrolpump.admin.service.MachineService;
import org.petrolpump.admin.service.MachineServiceImpl;
import java.util.*;

@WebServlet("/allocatemachine")
public class AllocateMachineToEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("admindashbord.jsp");
		r.include(request, response);
		MachineService mService=new MachineServiceImpl();
		List<Object[]> list=mService.getAllMachines();
		LinkedHashMap<Integer,String> hs=new LinkedHashMap<Integer,String>();
		for(Object[] obj:list) {
			hs.put((Integer)obj[3], obj[0].toString());
		}
		
		int empId=Integer.parseInt(request.getParameter("empid"));
		String empName=request.getParameter("empName");
		out.println("<h3>Hey "+empName+"we are going to allocate machine</h3>");
		out.println("<div class='col py-3'>");
		out.println("<form class='formarea' name='frm' action='finalmachineallocate' method='POST'>");
		out.println("<input type='hidden' name='empId' value='"+empId+"'/>");
		out.println("<select name='mid'  class='control'/>");
		out.println("<option>Select Machine</option>");
		Set<Map.Entry<Integer, String>> s=hs.entrySet();
		for(Map.Entry<Integer, String> m:s) {
			out.println("<option value='"+m.getKey()+"'>");
			out.println(m.getValue());
			out.println("</option>");
		}
		out.println("</select><br><br>");
		out.println("<input type='time' name='startTime' value='' class='control'/><br><br>");
		out.println("<input type='time' name='endTime' value='' class='control'/><br><br>");
		out.println("<input type='date' name='allDate' value='' class='control'/><br><br>");
		out.println("<input type='submit' name='s' value='Allocate Machine to Employees' class='control'/><br><br>");
		out.println("</div></div></div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
