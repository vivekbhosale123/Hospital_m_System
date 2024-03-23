package org.opd.service;

import java.util.List;

import org.opd.module.DegreeModule;
import org.opd.module.DoctorModule;

public interface DegreeService {
  public boolean isDegreeAdd(DegreeModule dmm);
  public List<DegreeModule> getDegrees();
//  public List<DegreeModule> viewAll();
}
