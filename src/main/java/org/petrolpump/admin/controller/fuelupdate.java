package org.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.petrolpump.admin.model.FuelTypeModel;
import org.petrolpump.admin.model.MachineModel;
import org.petrolpump.admin.service.FuelService;
import org.petrolpump.admin.service.FuelTypeServiceImpl;
import org.petrolpump.admin.service.MachineService;
import org.petrolpump.admin.service.MachineServiceImpl;


@WebServlet("/fupdate")
public class fuelupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("s");
		if(btn!=null) {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			FuelTypeModel model=new FuelTypeModel();
			model.setId(id);
			model.setName(name);
			FuelService fService=new FuelTypeServiceImpl();
			boolean b=fService.isUpdateFuelType(model);
			if(b) {
				RequestDispatcher r=request.getRequestDispatcher("viewfueltype.jsp");
				r.forward(request, response);
			}else {
				out.println("<h1>Fuel Type Not Updated<h1>");
			}
	     }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
