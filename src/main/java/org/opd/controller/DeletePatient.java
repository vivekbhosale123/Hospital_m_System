package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opd.service.PatientService;
import org.opd.service.PatientServiceImple;
@WebServlet("/DeletePatient")
public class DeletePatient extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		PatientService ds=new PatientServiceImple();
		int id=Integer.parseInt(request.getParameter("pid"));		
		boolean b=ds.Delete(id);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("ViewAllPatient");
			r.include(request, response);
			out.println("<h1>deleted........</h1>");
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("ViewAllPatient");
			r.include(request, response);
			out.println("<h1>not deleted updated........</h1>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
