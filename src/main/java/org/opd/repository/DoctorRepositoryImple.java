package org.opd.repository;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import org.opd.module.DoctorModule;

public class DoctorRepositoryImple extends DBconfig implements DoctorRepository{
	int count;
//	List<Object[]> list=new ArrayList<Object[]>();
	public boolean isAddDoctor(DoctorModule dm) {
		try {
			stmt=conn.prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?)");
			stmt.setInt(1,dm.getId());
			stmt.setString(2,dm.getName());
			stmt.setString(3,dm.getEmail());
			stmt.setString(4,dm.getContact());
			stmt.setString(5,dm.getAddress());
			stmt.setInt(6,dm.getExp());
			stmt.setInt(7,dm.getAge());
			stmt.setString(8,dm.getGender());
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
	public int getDoctorId() {
		try {
			stmt=conn.prepareStatement("select max(did) from doctor");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}
			++count;
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
		}
		return count;
	}
//
//	@Override
//	public boolean isCompleteDoctorProfile(int did, String[] dgid, String[] spid, String[] clgid) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public List<DoctorModule> viewAll() {
		try {
			ArrayList<DoctorModule> list=new ArrayList<DoctorModule>();
			stmt=conn.prepareStatement("select * from doctor");
			rs=stmt.executeQuery();
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
			return list;
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
	}

	@Override
	public List<DoctorModule> viewDoctorDetails() {
		try {
			ArrayList<DoctorModule> list=new ArrayList<DoctorModule>();
			stmt=conn.prepareStatement("select * from doctor");
			rs=stmt.executeQuery();
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
			return list;
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
	}

	@Override
	public boolean update(DoctorModule dm) {
		System.out.println(dm);
		try {
			if(dm.getGender().equals("male")) {
				dm.setGender("male");
			}
			else {
				dm.setGender("female");
			}
			stmt=conn.prepareStatement("update doctor set name=?,email=?,contact=?,address=?,exp=?,age=?,gender=? where did=?");
			stmt.setInt(8,dm.getId());
			stmt.setString(1,dm.getName());
			stmt.setString(2,dm.getEmail());
			stmt.setString(3,dm.getContact());
			stmt.setString(4,dm.getAddress());
			stmt.setInt(5, dm.getExp());
			stmt.setInt(6,dm.getAge());
			stmt.setString(7,dm.getGender());
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

	public boolean delete(int id) {
		try {
			stmt=conn.prepareStatement("delete from doctor where did=?");
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

//	@Override
//	public List<Object[]> getAllDoctors() {
//		try {
//			stmt=conn.prepareStatement("select did,name from doctor");
//			rs=stmt.executeQuery();
//			while(rs.next())
//			{
//				Object obj[]=new Object[] {rs.getInt(1),rs.getString(2)};
//				list.add(obj);
//			}
//			return list;
//		}
//		catch(SQLException ex)
//		{
//			System.out.println("error is "+ex);
//			return null;
//		}
//		
//	}
	

}
