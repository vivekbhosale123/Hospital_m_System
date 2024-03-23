package org.opd.repository;

import java.util.List;

import org.opd.module.DegreeModule;
import org.opd.module.SpecializationModule;

public interface SpecializationRepository {
  public boolean isAddSpecialization(SpecializationModule sm);
  public List<SpecializationModule> getSpecialization();
}
