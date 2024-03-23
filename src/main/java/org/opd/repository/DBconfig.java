package org.opd.repository;
import java.sql.*;
public class DBconfig {
   protected Connection conn;
   protected ResultSet rs;
   protected PreparedStatement stmt;
   
   public DBconfig()
   {
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Aai@8530");
	   }
	   catch(Exception ex)
	   {
		   System.out.println("exception is "+ex);
	   }
   }
}
