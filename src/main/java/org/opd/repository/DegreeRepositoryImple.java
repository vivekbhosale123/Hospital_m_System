package org.opd.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.opd.module.DegreeModule;
import org.opd.module.DoctorModule;

public class DegreeRepositoryImple extends DBconfig implements DegreeRepository 
{
	List<DegreeModule> list=new ArrayList<DegreeModule>();
	public boolean isAddDegree(DegreeModule dm) 
	{
		try 
		{
			stmt=conn.prepareStatement("insert into degree values('0',?)");
			stmt.setString(1,dm.getName());
			int val=stmt.executeUpdate();
			return val>0? true:false;
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return false;
		}
	}

	@Override
	public List<DegreeModule> getDegrees() {
		try {
			stmt=conn.prepareStatement("select * from degree");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				DegreeModule md=new DegreeModule();
				md.setId(rs.getInt(1));
				md.setName(rs.getString(2));
				list.add(md);
			}
			return list.size()>0?list:null;
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
		
	}

//	public List<DegreeModule> viewAll() {
//		try {
//			ArrayList<DoctorModule> list=new ArrayList<DoctorModule>();
//			stmt=conn.prepareStatement("select * from doctor");
//			rs=stmt.executeQuery();
//			while(rs.next())
//			{
//				DegreeModule dm=new DoeModule();
//				dm.setId(rs.getInt(1));
//				dm.setName(rs.getString(2));
//                list.add(dm);
//			}
//			return list;
//		}
//		catch(SQLException ex)
//		{
//			System.out.println("error is "+ex);
//			return null;
//		}
//		return null;
//	}
}
