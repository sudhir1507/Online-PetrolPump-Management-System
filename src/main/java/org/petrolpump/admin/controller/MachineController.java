package org.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.petrolpump.admin.model.MachineModel;
import org.petrolpump.admin.service.MachineService;
import org.petrolpump.admin.service.MachineServiceImpl;

/**
 * Servlet implementation class MachineController
 */
@WebServlet("/newmachine")
public class MachineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MachineService machineService=new MachineServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String machineCode=request.getParameter("machineCode");
		String ftypeId[]=request.getParameterValues("ftype");
		String capArray[]=request.getParameterValues("capacity");
		MachineModel model=new MachineModel();
		model.setMachineCode(machineCode);
		boolean b=machineService.isAddNewMachine(model,ftypeId,capArray);
		if(b) {
			
			out.println("<h1>Machine  Added Successfully..<h1>");
			
		}else {
			out.println("<h1>Machine Not Added..<h1>");
		}
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
