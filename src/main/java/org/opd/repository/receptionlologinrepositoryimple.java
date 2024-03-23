package org.opd.repository;
import java.sql.*;
import org.opd.module.receptionloginmodule;

public class receptionlologinrepositoryimple extends DBconfig implements receptionloginrepository{

	public boolean isValidate(receptionloginmodule rl) 
	{
		try {
			stmt=conn.prepareStatement("select * from reception where username=? and password=?");
			stmt.setString(1,rl.getUsername());
			stmt.setString(2, rl.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return false;
		}
	}

}
