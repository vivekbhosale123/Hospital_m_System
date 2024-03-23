package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opd.module.CollegeModule;
import org.opd.module.DegreeModule;
import org.opd.module.UniversityModule;
import org.opd.service.CollegeService;
import org.opd.service.CollegeServiceImple;
import org.opd.service.DegreeService;
import org.opd.service.DegreeServiceImple;
import org.opd.service.UniversityService;
import org.opd.service.UniversityServiceImple;
@WebServlet("/AddNewCollege")
public class AddNewCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add New College</title>");
		out.println("<link rel='stylesheet' href='css/AddNewCollege.css'>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("MasterPage.html");
		r.include(request, response);
		out.println("<form name='frm' action='' method='post'>");
		out.println("<div class='tab'>");
		out.println("<tr><td><input type='text' name='name' value='' placeholder='Enter your college'></td></tr><br>");
		out.println("<tr><td><input type='text' name='naccgrade' value='' placeholder='Enter your naacg'></td></tr><br>");
		out.println("<select name='uniname' class='control'>");
		UniversityService us=new UniversityServiceImple();
		List<UniversityModule> ulist=us.getAllUniversity();
		for(UniversityModule u:ulist)
		{
		out.println("<option>"+u.getName()+"</option>");
		}
		out.println("</select><br>");
		out.println("<tr><td><input type='submit' name='s' value='Add New college'></td></tr>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String ClgName=request.getParameter("name");
			String naccg=request.getParameter("naccgrade");
			String uname=request.getParameter("uniname");
			CollegeModule cm=new CollegeModule();
			cm.setCname(ClgName);
			cm.setNaccgrade(naccg);
			cm.setName(uname);
			CollegeService cs=new CollegeServiceImple();
			boolean b=cs.isAddCollege(cm);
			if(b)
			{
				out.println("<center><h1>New College Added...</h1></center>");
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
