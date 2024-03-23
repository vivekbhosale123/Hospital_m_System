package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opd.module.DoctorModule;
import org.opd.service.DoctorService;
import org.opd.service.DoctorServiceImple;
@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		DoctorService ds=new DoctorServiceImple();
		int id=Integer.parseInt(request.getParameter("did"));		
		boolean b=ds.delete(id);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("ViewAllDoctor");
			r.include(request, response);
			out.println("<h1>deleted........</h1>");
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("ViewAllDoctor");
			r.include(request, response);
			out.println("<h1>not deleted updated........</h1>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
