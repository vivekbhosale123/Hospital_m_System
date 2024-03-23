package org.opd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opd.module.PatientModule;
import org.opd.service.PatientService;
import org.opd.service.PatientServiceImple;
@WebServlet("/UpdatePatient")
public class UpdatePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("pid"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String diesese=request.getParameter("diesese");
		String adhar=request.getParameter("adhar");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(pid+" "+name+" "+email+" "+contact+" "+address+" "+age+" "+gender+" "+diesese+" "+adhar+" "+username+" "+password);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Patients Form</title>");
		out.println("<link rel='stylesheet' href='css/PatientsForm.css'>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("MasterPage.html");
		r.include(request, response);
		out.println("<form>");
		out.println("<div class='containn'>");
		out.println("<div class='row'>");
		out.println("<div class='col'>");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div><caption><h1>Patients Personal Info</h1></caption></div>");
		out.println("<div>");
		out.println("<label for=''>Full Name</label>");
		out.println("<label for='' class='p'>Email</label>");
		out.println("</div>");
		out.println("<div>");
		out.println("<input type='hidden' name='pid' value='"+pid+"' class='control' placeholder='Enter your id'>");
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
//		out.println("<input type='radio' name='gender' value='other' class='control' /><label for=''>Other</label>");
//		out.println("<input type='radio' name='gender' value='not specify' class='control' /><label for=''>Prefer not to say</label>");
		out.println("</div>");
		out.println("<div class='m'>");
		out.println("<input type='submit' name='s' value='Register Patients' class='control'>");
		out.println("</div>");
    	out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
//		out.println("</form>");
		String btn=request.getParameter("s");
		System.out.println(btn);
		if(btn!=null)
		{
			int p=Integer.parseInt(request.getParameter("pid"));
			String n=request.getParameter("name");
			String e=request.getParameter("email");
			String con=request.getParameter("contact");
			String ad=request.getParameter("address");
			int ag=Integer.parseInt(request.getParameter("age"));
			String gd=request.getParameter("gender");
			String di=request.getParameter("diesese");
			String adh=request.getParameter("adhar");
			String use=request.getParameter("username");
			String pass=request.getParameter("password");
			PatientModule pm=new PatientModule();
			pm.setId(p);
			pm.setName(n);
			pm.setEmail(e);
			pm.setContact(con);
			pm.setAddress(ad);
			pm.setAge(ag);
			pm.setGender(gd);
			pm.setDiesese(di);
			pm.setAdhar(adh);
			pm.setUsername(use);
			pm.setPassword(pass);
			PatientService pSer=new PatientServiceImple();
			boolean b=pSer.update(pm);
			if(b)
			{
				RequestDispatcher rs=request.getRequestDispatcher("ViewAllPatient");
				rs.forward(request, response);
				out.println("<center><h1>New Patient Updated.....</h1></center>");
			}
			else
			{
				RequestDispatcher rs=request.getRequestDispatcher("UpdatePatient");
				rs.include(request, response);
				out.println("<center><h1>some problem here.....</h1></center>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
