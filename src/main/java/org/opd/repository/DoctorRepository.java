package org.opd.repository;

import java.util.List;

import org.opd.module.DoctorModule;

public interface DoctorRepository {
  public boolean isAddDoctor(DoctorModule dm);
  public int getDoctorId();
  public List<DoctorModule> viewAll();
  public List<DoctorModule> viewDoctorDetails();
  public boolean update(DoctorModule dm);
  public boolean delete(int id);
//  public boolean deleteById(int did);
//  public boolean isCompleteDoctorProfile(int did,String []dgid,String []spid,String []clgid);
//  public List<Object[]> getAllDoctors();
}
