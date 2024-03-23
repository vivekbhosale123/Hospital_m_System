package org.opd.repository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.opd.module.SpecializationModule;
public class SpecializationRepositoryImple extends DBconfig implements SpecializationRepository{
	
	List<SpecializationModule> list=new ArrayList<SpecializationModule>();
	public boolean isAddSpecialization(SpecializationModule sm) {
		try {
			stmt=conn.prepareStatement("insert into specialization values('0',?)");
			stmt.setString(1,sm.getName());
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
	public List<SpecializationModule> getSpecialization() {
		try {
			stmt=conn.prepareStatement("select * from specialization");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				SpecializationModule sm=new SpecializationModule();
				sm.setId(rs.getInt(1));
				sm.setName(rs.getString(2));
				list.add(sm);
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
