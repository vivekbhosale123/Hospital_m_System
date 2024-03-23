package org.opd.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.opd.module.SpecializationModule;
import org.opd.module.UniversityModule;

public class UniversityRepositoryImple extends DBconfig implements UniversityRepository {
	List<UniversityModule> list=new ArrayList<UniversityModule>();

	@Override
	public boolean isAddUniversity(UniversityModule um) {
		try {
			stmt=conn.prepareStatement("insert into university values('0',?,?)");
			stmt.setString(1,um.getName());
			stmt.setString(2,um.getAddress());
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

	@Override
	public List<UniversityModule> getAllUniversity() {
		try {
			stmt=conn.prepareStatement("select * from university");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				UniversityModule um=new UniversityModule();
				um.setId(rs.getInt(1));
				um.setName(rs.getString(2));
				um.setAddress(rs.getString(3));
				list.add(um);
			}
			return list.size()>0?list:null;
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
	}
}
