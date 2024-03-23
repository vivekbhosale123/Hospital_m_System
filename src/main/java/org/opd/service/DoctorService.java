package org.opd.service;

import java.util.List;

import org.opd.module.DoctorModule;

public interface DoctorService {
   public boolean isAddDoctor(DoctorModule dm);
   public int getDoctorId();
   public List<DoctorModule> viewAll();
   public List<DoctorModule> viewDoctorDetails();
   public boolean update(DoctorModule dm);
   public boolean delete(int id);
}
