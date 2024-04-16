package org.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.petrolpump.admin.service.FuelService;
import org.petrolpump.admin.service.FuelTypeServiceImpl;



@WebServlet("/delfuel")
public class DeleteDFuelTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		FuelService fService=new FuelTypeServiceImpl();
		boolean b=fService.isDeleteFuelTypeById(id);
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("viewfueltype.jsp");
			r.forward(request, response);
		}else {
			out.println("<h1>Some problem is there</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
