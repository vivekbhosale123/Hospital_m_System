package org.opd.repository;

import java.util.List;

import org.opd.module.CollegeModule;

public interface CollegeRepository {
	public boolean isAddCollege(CollegeModule um);
	  public List<CollegeModule> getAllColleges();
}
