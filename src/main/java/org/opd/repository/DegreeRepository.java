package org.opd.repository;

import java.util.List;
import org.opd.module.DegreeModule;
import org.opd.module.DoctorModule;

public interface DegreeRepository {
   public boolean isAddDegree(DegreeModule dm);
   public List<DegreeModule> getDegrees();
//   public List<DegreeModule> viewAll();
}
