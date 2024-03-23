package org.opd.service;
import java.util.List;
import org.opd.module.CollegeModule;

public interface CollegeService {
  public boolean isAddCollege(CollegeModule um);
  public List<CollegeModule> getAllColleges();
}
