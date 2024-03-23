package org.opd.service;
import org.opd.repository.*;

import java.util.List;

import org.opd.module.PatientModule;

public class PatientServiceImple implements PatientService{
	PatientsRepository pRepo=new PatientRepositoryImple();
	public boolean isAddPatient(PatientModule pm) {
		
		return pRepo.isAddPatient(pm);
	}
	@Override
	public List<PatientModule> viewAll() {
		return pRepo.viewAll();
	}
	@Override
	public List<PatientModule> ViewPatientDetails() {
		return pRepo.ViewPatientDetails();
	}
	@Override
	public boolean Delete(int id) {
		return pRepo.Delete(id);
	}
	@Override
	public boolean update(PatientModule pm) {
		return pRepo.update(pm);
	}

}
