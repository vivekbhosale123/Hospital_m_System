package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opd.module.CollegeModule;
import org.opd.module.DegreeModule;
import org.opd.module.SpecializationModule;
import org.opd.module.UniversityModule;
import org.opd.service.CollegeService;
import org.opd.service.CollegeServiceImple;
import org.opd.service.DegreeService;
import org.opd.service.DegreeServiceImple;
import org.opd.service.SpecializationService;
import org.opd.service.SpecializationServiceImple;
import org.opd.service.UniversityService;
import org.opd.service.UniversityServiceImple;
@WebServlet("/DoctorProfessionalInfo")
public class DoctorProfessionalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Doctor Professional Page</title>");
		out.println("<link rel='stylesheet' href='css/DPI.css'>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("MasterPage.html");
		r.include(request, response);
		int doctorId=Integer.parseInt(request.getAttribute("doctorId").toString());
		out.println("<form name='frm' action='DoctorProfileComplete' method='post'>");
		out.println("<div class='PreContainer'>");
		out.println("<div class='DegreeContainer'>");
		out.println("<h1>Degree</h1>");
		out.println("<table>");
		out.println("<input type='text' name='did' value='"+doctorId+"' class='control'>");
		DegreeService dss=new DegreeServiceImple();
		List<DegreeModule> list=dss.getDegrees();
		Iterator<DegreeModule> i=list.iterator();
		while(i.hasNext())
		{
		DegreeModule dm=i.next();
		out.println("<tr>");
		out.println("<td><input type='checkbox' name='degree' value='"+dm.getId()+"'>"+dm.getName()+"</td>");
		if(i.hasNext())
		{
		 dm=i.next();
		 out.println("<td><input type='checkbox' name='degree' value='"+dm.getId()+"'>"+dm.getName()+"</td>");
		}
		out.println("</tr>");
		}
		out.println("<button><a href='AddNewDegree'>Add new Degree</a></button>");
		out.println("</table>");
		out.println("</div>");
		out.println("<div class='splContainer'>");
		out.println("<h1>Specialization</h1>");
		out.println("<table>");
		SpecializationService pss=new SpecializationServiceImple();
		List<SpecializationModule> splist=pss.getSpecialization();
		Iterator<SpecializationModule> ii=splist.iterator();
		while(ii.hasNext())
		{
		SpecializationModule sm=ii.next();
		out.println("<tr>");
		out.println("<td><input type='checkbox' name='spl' value='"+sm.getId()+"'>"+sm.getName()+"</td>");
		if(ii.hasNext())
		{
		sm=ii.next();
		out.println("<td><input type='checkbox' name='spl' value='"+sm.getId()+"'>"+sm.getName()+"</td>");
		}
		out.println("</tr>");
		}
		out.println("<button><a href='AddNewSpecialization'>Add new Specialization</a></button>");
		out.println("</table>");
		out.println("</div>");
		out.println("<div class='uniContainer'>");
		out.println("<h1>University</h1>");
		UniversityService uss=new UniversityServiceImple();
		List<UniversityModule> ulist=uss.getAllUniversity();
		out.println("<table>");
		if(ulist!=null)
		{
		Iterator<UniversityModule> ui=ulist.iterator();
		while(ui.hasNext())
		 {
		UniversityModule um=ui.next();
		out.println("<tr>");
		out.println("<td><input type='checkbox' name='uni' value='"+um.getId()+"'>"+um.getName()+"</td>");
		if(ui.hasNext())
		{
		um=ui.next();
		out.println("<td><input type='checkbox' name='uni' value='"+um.getId()+"'>"+um.getName()+"</td>");
		}
		out.println("</tr>");
		 }
		}
		else
		{
			out.println("<center><h1>No university present.....</h1><center>");
		}
		out.println("<button><a href='AddNewUniversity'>Add new University</a></button>");
		out.println("</table>");
		out.println("</div>");
		out.println("<div class='collgContainer'>");
		out.println("<h1>College</h1>");
		out.println("<table>");
//		CollegeService cm=new CollegeServiceImple();
//		List<CollegeModule> clist=cm.getAllColleges();
//		Iterator<CollegeModule> ci=clist.iterator();
//		while(ci.hasNext())
//		{
//		CollegeModule cmm=ci.next();
		out.println("<tr>");
		out.println("<td><input type='checkbox' name='clg' value='ICEM'>ICEM</td>");
//		if(i.hasNext())
//		{
//		 cmm=ci.next();
		 out.println("<td><input type='checkbox' name='clg' value='SP'>SP</td>");
//		}
		out.println("</tr>");
//		}
		out.println("<button><a href='AddNewCollege'>Add new College</a></button>");
		out.println("</table>");
		out.println("<center><input type='submit' name='s' value='Comple Doctor Profile' class='control'></center>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
