package org.opd.repository;

import java.util.List;

import org.opd.module.UniversityModule;

public interface UniversityRepository {
 public boolean isAddUniversity(UniversityModule um);
 public List<UniversityModule> getAllUniversity();
}
