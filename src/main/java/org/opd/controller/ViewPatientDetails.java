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
import org.opd.module.PatientModule;
import org.opd.service.DoctorService;
import org.opd.service.DoctorServiceImple;
import org.opd.service.PatientService;
import org.opd.service.PatientServiceImple;
@WebServlet("/ViewPatientDetails")
public class ViewPatientDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    PatientService ds=new PatientServiceImple();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Patients Form</title>");
		out.println("<link rel='stylesheet' href='css/PatientsForm.css'>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("MasterPage.html");
		r.include(request, response);
		out.println("<form name='frm' action='' method='get'>");
		out.println("<div class='containn'>");
		out.println("<div class='row'>");
		out.println("<div class='col'>");
		out.println("<form action=''>");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String diesese=request.getParameter("diesese");
		String adhar=request.getParameter("adhar");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
				out.println("<div><caption><h1>Patients Personal Info</h1></caption></div>");
				out.println("<div>");
				out.println("<label for=''>Full Name</label>");
				out.println("<label for='' class='p'>Email</label>");
				out.println("</div>");
				out.println("<div>");
				out.println("<input type='text' name='name' value='"+name+"' class='control' placeholder='Enter your Name'>");
				out.println("<input type='email' name='email' value='"+email+"' class='control' placeholder=\'Enter your Email\'>");
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
				out.println("<label for=''>Diecese</label>");
				out.println("<label for='' class='pp'>Adhar Number</label>");
				out.println("</div>");
				out.println("<div>");
				out.println("<input type='text' name='diesese' value='"+diesese+"' class='control' placeholder='Enter your Diesese\'>");
				out.println("<input type='number' name='adhar' value='"+adhar+"' class='control' placeholder='Enter Your Adhar Number\'>");
				out.println("</div>");
				out.println("<div>");
				out.println("<label for=''>Username</label>");
				out.println("<label for='' class='r'>Password</label>");
				out.println("</div>");
				out.println("<div>");
				out.println("<input type='text' name='username' value='"+username+"' class='control' placeholder='Enter Your Username\'>");
				out.println("<input type='password' name='password' value='"+password+"' class='control' placeholder=\'Enter Your Password\'>");
				out.println("</div>");
				out.println("<div>");
				out.println("<div>");
				out.println("<label for=''>Age</label>");
				out.println("</div>");
				out.println("<div>");
				out.println("<input type='text' name='age' value='"+age+"' class='control' placeholder='Enter your Age\'>");
				out.println("</div>");
				out.println("<label for=''>Gender</label>");
				out.println("</div>");
				out.println("<div class='t'>");
				out.println("<input type='radio' name='gender' value='"+gender+"' class='control' /><label for=''>Male</label>");
				out.println("<input type='radio' name='gender' value='"+gender+"' class='control' /><label for=''>Female</label>");
				out.println("<input type='radio' name='gender' value='"+gender+"' class='control' /><label for=''>Other</label>");
				out.println("<input type='radio' name='gender' value='"+gender+"' class='control' /><label for=''>Prefer not to say</label>");
				out.println("</div>");
				out.println("<div class='m'>");
				out.println("<input type='submit' name='s' value='Register Patients' class='control'>");
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
