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

import org.opd.module.DoctorModule;
import org.opd.service.DoctorService;
import org.opd.service.DoctorServiceImple;
@WebServlet("/ViewAllDoctor")
public class ViewAllDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  DoctorService ds=new DoctorServiceImple();
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
		  List<DoctorModule>list=ds.viewAll();
		  for(DoctorModule m:list)
		  {
			  out.println("<tr><td>"+m.getName()+"</td><td>"+m.getEmail()+"</td><td><a href='DeleteDoctor?did="+m.getId()+"'>Delete</a></td>"
			  		+ "<td><a href='UpdateDoctor?id="+m.getId()+"&name="+m.getName()+"&email="+m.getEmail()+"&contact="+m.getContact()+"&address="+m.getAddress()+"&exp="+m.getExp()+"&age="+m.getAge()+"&gender="+m.getGender()+"'>Update</a></td>"
			  				+ "<td><a href='ViewDoctorDetails?name="+m.getName()+"&email="+m.getEmail()+"&contact="+m.getContact()+"&address="+m.getAddress()+"&exp="+m.getExp()+"&age="+m.getAge()+"&gender="+m.getGender()+"'>View</a></td></tr>");
		  }
		  out.println("</table>");
		  out.println("<div>");
		  out.println("</form>");
		  out.println("</body>");
		  out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
