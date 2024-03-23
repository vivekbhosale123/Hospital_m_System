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
import org.opd.service.SearchService;
import org.opd.service.SearchServiceImple;
@WebServlet("/SearchPatient")
public class SearchPatient extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  String n;
		  PrintWriter out=response.getWriter();
		  String name=request.getParameter("name");
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
		  out.println("<center><input type='text' name='v' value='' class='con' placeholder='Search Here'></center>");
		  out.println("<center><input type='submit' name='v' value='Search Doctor Name' class='cont'></center>");
		  out.println("</form>");
//		  out.println("<tr><th>Name</th><th>Email</th><th>Delete</th><th>Update</th><th>View</th></tr>");
//		  List<PatientModule>list=ps.viewAll();
//		  for(PatientModule m:list)
//		  {  
//			  out.println("<tr><td>"+m.getName()+"</td><td>"+m.getEmail()+"</td><td><a href='DeletePatient?pid="+m.getId()+"'>Delete</a></td><td>"
//			  		+ "<a href='UpdatePatient?pid="+m.getId()+"&name="+m.getName()+"&email="+m.getEmail()+"&contact="+m.getContact()+"&address="+m.getAddress()+"&age="+m.getAge()+"&gender="+m.getGender()+""
//			  				+ "&diesese="+m.getDiesese()+"&adhar="+m.getAdhar()+"&username="+m.getUsername()+"&password="+m.getPassword()+"'>Update</a></td>"
//			  				+ "<td><a href='ViewPatientDetails?name="+m.getName()+"&email="+m.getEmail()+"&contact="+m.getContact()+"&address="+m.getAddress()+"&diesese="+m.getDiesese()+"&adhar="+m.getAdhar()+"&username="+m.getUsername()+"&password="+m.getPassword()+"&age="+m.getAge()+"&gender="+m.getGender()+"'>View</a></td></tr>");
//		  }
		  out.println("</table>");
		  out.println("</div>");
		  out.println("<div class='m'>");
		  out.println("<table>");
		  String btn=request.getParameter("v");
		  if(btn!=null)
		  {
			System.out.println("hello");    
				n=btn;
				
				SearchService s1=new SearchServiceImple();
				List<PatientModule> list1=s1.isSearch(n);
				System.out.println(list1.toString());
				if(list1.size()>0)
				{
					
					for(PatientModule d1:list1)
				    {
				    	out.println("<tr><td>"+d1.getName()+"</td><td>"+d1.getEmail()+"</td><td><a href='DeletePatient?pid="+d1.getId()+"'>Delete</a></td><td>"
						  		+ "<a href='UpdatePatient?pid="+d1.getId()+"&name="+d1.getName()+"&email="+d1.getEmail()+"&contact="+d1.getContact()+"&address="+d1.getAddress()+"&age="+d1.getAge()+"&gender="+d1.getGender()+""
						  				+ "&diesese="+d1.getDiesese()+"&adhar="+d1.getAdhar()+"&username="+d1.getUsername()+"&password="+d1.getPassword()+"'>Update</a></td>"
						  				+ "<td><a href='ViewPatientDetails?name="+d1.getName()+"&email="+d1.getEmail()+"&contact="+d1.getContact()+"&address="+d1.getAddress()+"&diesese="+d1.getDiesese()+"&adhar="+d1.getAdhar()+"&username="+d1.getUsername()+"&password="+d1.getPassword()+"&age="+d1.getAge()+"&gender="+d1.getGender()+"'>View</a></td></tr>");
				    }
					
				}
				else
				{
					out.println("<center><h3>patient not found......</h3></center>");
				}	
		  }
		  out.println("</table>");
		  out.println("</div>");
		  out.println("</body>");
		  out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
