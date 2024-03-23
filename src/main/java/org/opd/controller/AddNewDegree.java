package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opd.module.DegreeModule;
import org.opd.service.DegreeService;
import org.opd.service.DegreeServiceImple;
@WebServlet("/AddNewDegree")
public class AddNewDegree extends HttpServlet {
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
		out.println("<tr><td><input type='text' name='degree' value='' placeholder='Enter your degree'></td></tr><br>");
		out.println("<tr><td><input type='submit' name='s' value='Add New Degree'></td></tr>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String degreeN=request.getParameter("degree");
			DegreeModule dm=new DegreeModule();
			dm.setName(degreeN);
			DegreeService dss=new DegreeServiceImple();
			boolean b=dss.isDegreeAdd(dm);
			if(b)
			{
				out.println("<center><h1>New Degree Added...</h1></center>");
			}
			else
			{
				out.println("<center><h1>some problem...</h1></center>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
