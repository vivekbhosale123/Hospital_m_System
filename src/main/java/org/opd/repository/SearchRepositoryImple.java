package org.opd.repository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.opd.module.PatientModule;
public class SearchRepositoryImple extends DBconfig implements SearchRepository {
	public List<PatientModule> isSearch(String n){
		try {
			System.out.println(n);
			stmt=conn.prepareStatement("select * from patient where name=?");
			stmt.setString(1, n);;
			rs=stmt.executeQuery();
			ArrayList<PatientModule> list=new ArrayList<PatientModule>();
			while(rs.next())
			{
				PatientModule pm=new PatientModule();
				pm.setId(rs.getInt(1));
				pm.setName(rs.getString(2));
				pm.setEmail(rs.getString(3));
				pm.setContact(rs.getString(4));
				pm.setAddress(rs.getString(5));
				pm.setAge(rs.getInt(6));
				pm.setGender(rs.getString(7));
                pm.setDiesese(rs.getString(8));
                pm.setAdhar(rs.getString(9));
                pm.setUsername(rs.getString(10));
                pm.setPassword(rs.getString(11));
                list.add(pm);
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
