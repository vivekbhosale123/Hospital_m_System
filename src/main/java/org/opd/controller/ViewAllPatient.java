package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opd.module.PatientModule;
import org.opd.service.PatientService;
import org.opd.service.PatientServiceImple;
@WebServlet("/ViewAllPatient")
public class ViewAllPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  PatientService ps=new PatientServiceImple();
		  out.println("<title>form</title>"); 
		  out.println("<link rel='stylesheet' href='css/ViewAllDoctor.css'>");
		  out.println("</head>");
		  out.println("<body>");
		  RequestDispatcher r=request.getRequestDispatcher("MasterPage.html");
		  r.include(request, response);
		  out.println("<form name='frm' action='' method='post' class='control'>");
		  out.println("<div class='m'>");
		  out.println("<table>");
		  out.println("<tr><th>Name</th><th>Email</th><th>Delete</th><th>Update</th><th>View</th></tr>");
		  List<PatientModule>list=ps.viewAll();
		  for(PatientModule m:list)
		  {  
			  out.println("<tr><td>"+m.getName()+"</td><td>"+m.getEmail()+"</td><td><a href='DeletePatient?pid="+m.getId()+"'>Delete</a></td><td>"
			  		+ "<a href='UpdatePatient?pid="+m.getId()+"&name="+m.getName()+"&email="+m.getEmail()+"&contact="+m.getContact()+"&address="+m.getAddress()+"&age="+m.getAge()+"&gender="+m.getGender()+""
			  				+ "&diesese="+m.getDiesese()+"&adhar="+m.getAdhar()+"&username="+m.getUsername()+"&password="+m.getPassword()+"'>Update</a></td>"
			  				+ "<td><a href='ViewPatientDetails?name="+m.getName()+"&email="+m.getEmail()+"&contact="+m.getContact()+"&address="+m.getAddress()+"&diesese="+m.getDiesese()+"&adhar="+m.getAdhar()+"&username="+m.getUsername()+"&password="+m.getPassword()+"&age="+m.getAge()+"&gender="+m.getGender()+"'>View</a></td></tr>");
		  }
		  out.println("</table>");
		  out.println("<div>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
