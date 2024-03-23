package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DoctorProfileComplete")
public class DoctorProfileComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int doctorId=Integer.parseInt(request.getParameter("did"));
		out.println("<h1>Doctor id is &nbsp;"+doctorId+"</h1>");
		String degreeIds[]=request.getParameterValues("degree");
		out.println("<h1>Doctor IDS</h1>");	
		for(int i=0;i<degreeIds.length;i++)
		{
			out.println(degreeIds[i]+"&nsbp;&nbsp;&nsbp");
		}
		out.println("<h1>Doctor Specialization</h1>");
		String spl[]=request.getParameterValues("spl");
		for(int i=0;i<spl.length;i++)
		{
			out.println(spl[i]+"&nsbp;&nbsp;&nsbp");
		}
		out.println("<h1>Doctor college</h1>");
		String clg[]=request.getParameterValues("clg");
		for(int i=0;i<clg.length;i++)
		{
			out.println(clg[i]+"&nsbp;&nbsp;&nsbp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
