package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opd.module.DoctorModule;
import org.opd.service.DoctorService;
import org.opd.service.DoctorServiceImple;
@WebServlet("/Addnewdoctor")
public class Addnewdoctor extends HttpServlet {
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
		out.println("<form name='frm' action='' method='post'>");
		out.println("<div class='contain'>");
		out.println("<div class='row'>");
		out.println("<div class='col'>");
		out.println("<form action=''>");
		out.println("<div><caption><h1>Doctor Personal Info</h1></caption></div>");
		DoctorService dsp=new DoctorServiceImple();
		int did=dsp.getDoctorId();
		out.println("<div>");
		out.println("<input type='text' name='did' value='"+did+"' class='control' placeholder='Enter your doctor id'>");
		out.println("</div>");
		out.println("<div>");
		out.println("<label for=''>Full Name</label>");
		out.println("<label for='' class='p'>Email</label>");
		out.println("</div>");
		out.println("<div>");
		out.println("<input type='text' name='name' value='' class='control' placeholder='Enter your Name'>");
		out.println("<input type='email' name='email' value='' class='control' placeholder='Enter your Email'>");
		out.println("</div>");
		out.println("<div>");
		out.println("<label for=''>Contact</label>");
		out.println("<label for='' class='pp'>Address</label>");
		out.println("</div>");
		out.println("<div>");
		out.println("<input type='number' name='contact' value='' class='control' placeholder='Enter your Number'>");
		out.println("<input type='text' name='address' value='' class='control' placeholder='Enter your Address'>");
		out.println("</div>");
		out.println("<div>");
		out.println("<label for=''>Experience</label>");
		out.println("<label for='' class='r'>Age</label>");
		out.println("</div>");
		out.println("<div>");
		out.println("<input type='text' name='exp' value='' class='control' placeholder='Enter your Experience'>");
		out.println("<input type='text' name='age' value='' class='control' placeholder='Enter your Age'>");
		out.println("</div>");
		out.println("<div>");
		out.println("<label for=''>Gender</label>");
		out.println("</div>");
		out.println("<div class='t'>");
		out.println("<input type='radio' name='gender' value='male' class='control' /><label for=''>Male</label>");
		out.println("<input type='radio' name='gender' value='female' class='control' /><label for=''>Female</label>");
		out.println("<input type='radio' name='gender' value='other' class='control' /><label for=''>Other</label>");
		out.println("<input type='radio' name='gender' value='not specify' class='control' /><label for=''>Prefer not to say</label>");
		out.println("</div>");
		out.println("<div class='m'>");
		out.println("<input type='submit' name='s' value='Register' class='control'>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			did=Integer.parseInt(request.getParameter("did"));
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			String address=request.getParameter("address");
			int exp=Integer.parseInt(request.getParameter("exp"));
			int age=Integer.parseInt(request.getParameter("age"));
			String gender=request.getParameter("gender");
			DoctorModule dm=new DoctorModule();
			dm.setId(did);
			dm.setName(name);
			dm.setEmail(email);
			dm.setContact(contact);
			dm.setAddress(address);
			dm.setExp(exp);
			dm.setAge(age);
			dm.setGender(gender);
			DoctorService ds=new DoctorServiceImple();
			/*
			 List<DoctorModule>list=ds.viewAll();
			 for(DoctorModule d:list)
			 {
			 DoctorModule dm=(DoctorModule)d.next();
			 }
			 
			 */
			boolean b=ds.isAddDoctor(dm);
			if(b)
			{
			   r=request.getRequestDispatcher("DoctorProfessionalInfo");  
			   request.setAttribute("doctorId",did);
			   r.forward(request, response);
			}
			else
			{
			   out.println("<center><h2>some problem here......</h2></center>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	

}
