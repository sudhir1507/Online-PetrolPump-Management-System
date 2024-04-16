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


@WebServlet("/finalmachineupdate")
public class FinalMachineUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FinalMachineUpdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("s");
		if(btn!=null) {
			int mid=Integer.parseInt(request.getParameter("mid"));
			String machineCode=request.getParameter("mcode");
			MachineModel model=new MachineModel();
			model.setId(mid);
			model.setMachineCode(machineCode);
			MachineService mService=new MachineServiceImpl();
			boolean b=mService.isUpdateMachine(model);
			if(b) {
				RequestDispatcher r=request.getRequestDispatcher("viewmachine.jsp");
				r.forward(request, response);
			}else {
				out.println("<h1>Machine Data Not Updated<h1>");
			}
		}
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
