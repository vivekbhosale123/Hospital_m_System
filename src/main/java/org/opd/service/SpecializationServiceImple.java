package org.opd.service;

import java.util.List;

import org.opd.module.SpecializationModule;
import org.opd.repository.SpecializationRepository;
import org.opd.repository.SpecializationRepositoryImple;

public class SpecializationServiceImple implements SpecializationService{
	SpecializationRepository sRepo=new SpecializationRepositoryImple();
	public boolean isAddSpecialization(SpecializationModule sm) {
		return sRepo.isAddSpecialization(sm);
	}
	@Override
	public List<SpecializationModule> getSpecialization() {
		// TODO Auto-generated method stub
		return sRepo.getSpecialization();
	}

}
