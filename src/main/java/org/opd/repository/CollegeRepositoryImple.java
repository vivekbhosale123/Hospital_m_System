package org.opd.repository;
import java.util.List;
import java.sql.*;
import org.opd.module.*;
public class CollegeRepositoryImple extends DBconfig implements CollegeRepository{

	@Override
	public boolean isAddCollege(CollegeModule cm) {
		try {
			int uid=this.getUniversityId(cm.getName());//send university name
			stmt=conn.prepareStatement("insert into college values('0',?,?,?)");
			stmt.setString(1,cm.getCname());
			stmt.setString(2,cm.getNaccgrade());
			stmt.setInt(3, uid);
			int val=stmt.executeUpdate();
			if(val>0)
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
	public int getUniversityId(String name)
	{
		try {
			stmt=conn.prepareStatement("select uid from university where name=?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);//return university by id;
			}
			else
			{
				return 0;
			}
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
			return -1;
		}
	}

	@Override
	public List<CollegeModule> getAllColleges() {
		// TODO Auto-generated method stub
		return null;
	}

}
