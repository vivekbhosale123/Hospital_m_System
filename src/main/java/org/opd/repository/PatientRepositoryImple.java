package org.opd.repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.opd.module.DoctorModule;
import org.opd.module.PatientModule;

public class PatientRepositoryImple extends DBconfig implements PatientsRepository{
	public boolean isAddPatient(PatientModule pm) {
		try {
			stmt=conn.prepareStatement("insert into patient values('0',?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,pm.getName());
			stmt.setString(2,pm.getEmail());
			stmt.setString(3,pm.getContact());
			stmt.setString(4,pm.getAddress());
			stmt.setInt(5,pm.getAge());
			stmt.setString(6,pm.getGender());
			stmt.setString(7,pm.getDiesese());
			stmt.setString(8,pm.getAdhar());
			stmt.setString(9,pm.getUsername());
			stmt.setString(10,pm.getPassword());
			int val=stmt.executeUpdate();
//			if(val>0)
//			{
//				stmt=conn.prepareStatement("select max(pid) from patient");
//				rs=stmt.executeQuery();
//				if(rs.next())
//				{
//					java.util.Date d1=new java.util.Date();
//					int year=d1.getYear();
//					int month=d1.getMonth();
//					int day=d1.getDate();
//					java.sql.Date dt=new java.sql.Date(year, month, day);
//					int pid=rs.getInt(1);
//					stmt=conn.prepareStatement("insert into allocatedoctor(pid,did,rdate) values(?,?,?)");
//					stmt.setInt(1, pid);
////				stmt.setInt(2,pm.getDoctorId());
//					stmt.setDate(2,dt);
//					val=stmt.executeUpdate();
					return val>0?true:false;
//				}
//				else
//				{
//					return false;
//				}
//			}
//			else
//			{
//				return false;
//			}
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return false;
		}
	}

	@Override
	public List<PatientModule> viewAll() {
		try {
			ArrayList<PatientModule> list=new ArrayList<PatientModule>();
			stmt=conn.prepareStatement("select * from patient");
			rs=stmt.executeQuery();
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
			return list;
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
	}

	@Override
	public List<PatientModule> ViewPatientDetails() {
		try {
			ArrayList<PatientModule> list=new ArrayList<PatientModule>();
			stmt=conn.prepareStatement("select * from patient");
			rs=stmt.executeQuery();
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
			return list;
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
	}

	@Override
	public boolean Delete(int id) {
		try {
			stmt=conn.prepareStatement("delete from patient where pid=?");
			stmt.setInt(1, id);
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
	public boolean update(PatientModule pm) {
		try {
			if(pm.getGender().equals("male")) {
				pm.setGender("male");
			}
			else {
				pm.setGender("female");
			}
			stmt=conn.prepareStatement("update patient set name=?,email=?,contact=?,address=?,age=?,gender=?,diesese=?,adhar=?,username=?,password=? where pid=?");
			
			stmt.setString(1,pm.getName());
			stmt.setString(2,pm.getEmail());
			stmt.setString(3,pm.getContact());
			stmt.setString(4,pm.getAddress());
			stmt.setInt(5,pm.getAge());
			stmt.setString(6,pm.getGender());
			stmt.setString(7,pm.getDiesese());
			stmt.setString(8,pm.getAdhar());
			stmt.setString(9,pm.getUsername());
			stmt.setString(10,pm.getPassword());
			stmt.setInt(11,pm.getId());
			System.out.println(pm.getDiesese()+"\t"+pm.getContact());
			int val=stmt.executeUpdate();
			System.out.println(val);
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
}
