package org.opd.service;

import java.util.List;

import org.opd.module.DoctorModule;
import org.opd.module.PatientModule;

public interface PatientService {
  public boolean isAddPatient(PatientModule pm);
  public List<PatientModule> viewAll();
  public List<PatientModule> ViewPatientDetails();
  public boolean Delete(int id);
  public boolean update(PatientModule pm);
}
