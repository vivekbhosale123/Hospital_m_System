package org.opd.service;

import java.util.List;

import org.opd.module.UniversityModule;
import org.opd.repository.UniversityRepository;
import org.opd.repository.UniversityRepositoryImple;

public class UniversityServiceImple implements UniversityService{
	UniversityRepository uRepo=new UniversityRepositoryImple();
	public boolean isAddUniversity(UniversityModule um) {
		
		return uRepo.isAddUniversity(um);
	}

	@Override
	public List<UniversityModule> getAllUniversity() {
		
		return uRepo.getAllUniversity();
	}

}
