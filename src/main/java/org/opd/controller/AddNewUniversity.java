package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.opd.module.UniversityModule;
import org.opd.service.UniversityService;
import org.opd.service.UniversityServiceImple;
import org.opd.service.SpecializationServiceImple;
@WebServlet("/AddNewUniversity")
public class AddNewUniversity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add New Degree</title>");
		out.println("<link rel='stylesheet' href='css/AddNewUniversity.css'>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("MasterPage.html");
		r.include(request, response);
		out.println("<form name='frm' action='' method='post'>");
		out.println("<div class='tab'>");
		out.println("<tr><td><input type='text' name='name' value='' placeholder='Enter your university'></td></tr><br>");
		out.println("<tr><td><input type='text' name='address' value='' placeholder='Enter your Address'></td></tr><br>");
		out.println("<tr><td><input type='submit' name='s' value='Add New University'></td></tr>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String uniname=request.getParameter("name");
			String uaddress=request.getParameter("address");
			UniversityModule um=new UniversityModule();
			um.setName(uniname);
			um.setAddress(uaddress);
			UniversityService us=new UniversityServiceImple();
			boolean b=us.isAddUniversity(um);
			if(b)
			{
				out.println("<center><h1>New University Added...</h1></center>");
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
		doGet(request, response);
	}

}
