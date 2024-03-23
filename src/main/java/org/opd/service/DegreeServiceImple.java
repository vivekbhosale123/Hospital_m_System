package org.opd.service;

import java.util.List;

import org.opd.module.DegreeModule;
import org.opd.module.DoctorModule;
import org.opd.repository.DegreeRepositoryImple;

public class DegreeServiceImple implements DegreeService {
    DegreeRepositoryImple drepo=new DegreeRepositoryImple();
	public boolean isDegreeAdd(DegreeModule dm) {
		
		return drepo.isAddDegree(dm);
	}
	@Override
	public List<DegreeModule> getDegrees() {
		
		return drepo.getDegrees();
	}
//	public List<DegreeModule> viewAll() {
//
//		return drepo.viewAll();
//	}

}
