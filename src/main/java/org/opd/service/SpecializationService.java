package org.opd.service;

import java.util.List;

import org.opd.module.SpecializationModule;

public interface SpecializationService {
 public boolean isAddSpecialization(SpecializationModule sm);
 public List<SpecializationModule> getSpecialization();
}
