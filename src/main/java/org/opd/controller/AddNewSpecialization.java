package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opd.module.SpecializationModule;
import org.opd.service.SpecializationService;
import org.opd.service.SpecializationServiceImple;
@WebServlet("/AddNewSpecialization")
public class AddNewSpecialization extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add New Degree</title>");
		out.println("<link rel='stylesheet' href='css/AddNewDegree.css'>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("MasterPage.html");
		r.include(request, response);
		out.println("<form name='frm' action='' method='post'>");
		out.println("<div class='tab'>");
		out.println("<tr><td><input type='text' name='name' value='' placeholder='Enter your specialization'></td></tr><br>");
		out.println("<tr><td><input type='submit' name='s' value='Add New Specialization'></td></tr>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String name=request.getParameter("name");
			SpecializationModule sm=new SpecializationModule();
			sm.setName(name);
			SpecializationService ss=new SpecializationServiceImple();
			boolean b=ss.isAddSpecialization(sm);
			if(b)
			{
				out.println("<center><h1>New specialization Added...</h1></center>");
			}
			else
			{
				out.println("<center><h1>some problem...</h1></center>");
			}
		}
		out.println("<html>");
		out.println("<head>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
