package org.opd.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.opd.module.receptionloginmodule;
import org.opd.service.receptionlogiincervice;
import org.opd.service.receptionloginserviceimple;
@WebServlet("/validate")
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		receptionloginmodule rl=new receptionloginmodule();
		rl.setUsername(username);
		rl.setPassword(password);
		receptionlogiincervice recserv=new receptionloginserviceimple();
		boolean b=recserv.isValidate(rl);
		if(b)
		{
		   RequestDispatcher r=request.getRequestDispatcher("MasterPage.html");
		   r.forward(request, response);
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("receptionlogin.html");
		    r.include(request, response);
			out.println("<center><h1>invalid pass and user</h1></center>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
