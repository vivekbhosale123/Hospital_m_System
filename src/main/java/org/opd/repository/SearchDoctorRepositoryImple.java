package org.opd.repository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.opd.module.DoctorModule;
import org.opd.module.PatientModule;
public class SearchDoctorRepositoryImple extends DBconfig implements SearchDoctorRepository{
	public List<DoctorModule> isSearch(String n) {
		try {
			System.out.println(n);
			stmt=conn.prepareStatement("select * from Doctor where name=?");
			stmt.setString(1, n);;
			rs=stmt.executeQuery();
			ArrayList<DoctorModule> list=new ArrayList<DoctorModule>();
			while(rs.next())
			{
				DoctorModule dm=new DoctorModule();
				dm.setId(rs.getInt(1));
				dm.setName(rs.getString(2));
				dm.setEmail(rs.getString(3));
				dm.setContact(rs.getString(4));
				dm.setAddress(rs.getString(5));
				dm.setExp(rs.getInt(6));
				dm.setAge(rs.getInt(7));
				dm.setGender(rs.getString(8));
                list.add(dm);
			}
			System.out.println(list);
			return list;
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
            return null;
		}
	}

}
