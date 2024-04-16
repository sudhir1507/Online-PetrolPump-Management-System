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


@WebServlet("/updmachine")
public class UpdateMachineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateMachineController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int mid=Integer.parseInt(request.getParameter("mid"));
		String machineCode=request.getParameter("mcode");
		RequestDispatcher r=request.getRequestDispatcher("admindashbord.jsp");
		r.include(request, response);
		out.println("<div class='col py-3'>");
		out.println("<form class='formarea' name='frm' action='finalmachineupdate' method='POST'>");
		out.println("<input type='hidden' name='mid' value='"+mid+"' class='control'/><br><br>");
		out.println("<input type='text' name='mcode' value='"+machineCode+"' class='control'/><br><br>");
		out.println("<input type='submit' name='s' value='Update Machine Code' class='control'/><br><br>");
		out.println("</div></div></div>");
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
