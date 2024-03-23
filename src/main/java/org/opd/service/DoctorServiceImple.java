package org.opd.service;

import java.util.List;

import org.opd.module.DoctorModule;
import org.opd.repository.DoctorRepository;
import org.opd.repository.DoctorRepositoryImple;

public class DoctorServiceImple implements DoctorService{
	DoctorRepository docRepo=new DoctorRepositoryImple();
	public boolean isAddDoctor(DoctorModule dm) {
		boolean b=docRepo.isAddDoctor(dm);
		return b;
	}
	public int getDoctorId() {
		
		return docRepo.getDoctorId();
	}
	public List<DoctorModule> viewAll() {
		
		return docRepo.viewAll();
	}
	public List<DoctorModule> viewDoctorDetails() {
		return docRepo.viewDoctorDetails();
	}
	public boolean update(DoctorModule dm) {
		System.out.println("In Service:"+dm);
		return docRepo.update(dm);
	}
	@Override
	public boolean delete(int id) {
		return docRepo.delete(id);
	}

}
