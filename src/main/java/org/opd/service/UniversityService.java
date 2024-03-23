package org.opd.service;

import java.util.List;

import org.opd.module.UniversityModule;

public interface UniversityService {
  public boolean isAddUniversity(UniversityModule um);
  public List<UniversityModule> getAllUniversity();
}
