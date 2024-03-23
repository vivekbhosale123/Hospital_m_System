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
@WebServlet("/ViewDoctorDetails")
public class ViewDoctorDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>login page</title>");
		out.println("<link rel='stylesheet' href='css/DoctorForm.css'>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("MasterPage.html");
		r.include(request, response);
		DoctorService ds=new DoctorServiceImple();
		out.println("<form name='frm' action='' method='post'>");
		out.println("<div class='contain'>");
		out.println("<div class='row'>");
		out.println("<div class='col'>");
		out.println("<form action=''>");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		int exp=Integer.parseInt(request.getParameter("exp"));
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
				out.println("<div><caption><h1>Doctor Personal Info</h1></caption></div>");
				out.println("<div>");
				out.println("<label for=''>Full Name</label>");
				out.println("<label for='' class='p'>Email</label>");
				out.println("</div>");
				out.println("<div>");
				out.println("<input type='text' name='name' value='"+name+"' class='control' placeholder='Enter your Name'>");
				out.println("<input type='email' name='email' value='"+email+"' class='control' placeholder='Enter your Email'>");
				out.println("</div>");
				out.println("<div>");
				out.println("<label for=''>Contact</label>");
				out.println("<label for='' class='pp'>Address</label>");
				out.println("</div>");
				out.println("<div>");
				out.println("<input type='number' name='contact' value='"+contact+"' class='control' placeholder='Enter your Number'>");
				out.println("<input type='text' name='address' value='"+address+"' class='control' placeholder='Enter your Address'>");
				out.println("</div>");
				out.println("<div>");
				out.println("<label for=''>Experience</label>");
				out.println("<label for='' class='r'>Age</label>");
				out.println("</div>");
				out.println("<div>");
				out.println("<input type='text' name='exp' value='"+exp+"' class='control' placeholder='Enter your Experience'>");
				out.println("<input type='text' name='age' value='"+age+"' class='control' placeholder='Enter your Age'>");
				out.println("</div>");
				out.println("<div>");
				out.println("<label for=''>Gender</label>");
				out.println("</div>");
				out.println("<div class='t'>");
				out.println("<input type='radio' name='gender' value='"+gender+"' class='control' /><label for=''>Male</label>");
				out.println("<input type='radio' name='gender' value='"+gender+"' class='control' /><label for=''>Female</label>");
				out.println("<input type='radio' name='gender' value='"+gender+"' class='control' /><label for=''>Other</label>");
				out.println("<input type='radio' name='gender' value='"+gender+"' class='control' /><label for=''>Prefer not to say</label>");
				out.println("</div>");
				out.println("<div class='m'>");
				out.println("<input type='submit' name='s' value='Register' class='control'>");
				out.println("</div>");
				out.println("</form>");	
			out.println("</div>");
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
