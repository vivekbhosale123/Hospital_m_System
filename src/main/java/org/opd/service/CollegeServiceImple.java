package org.opd.service;

import java.util.List;

import org.opd.module.CollegeModule;
import org.opd.repository.*;
public class CollegeServiceImple implements CollegeService{
	CollegeRepository clgRepo=new CollegeRepositoryImple();
	@Override
	public boolean isAddCollege(CollegeModule um) {
		// TODO Auto-generated method stub
		return clgRepo.isAddCollege(um);
	}

	@Override
	public List<CollegeModule> getAllColleges() {
		return clgRepo.getAllColleges();
	}

}
