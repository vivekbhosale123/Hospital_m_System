package org.opd.service;
import org.opd.module.*;
import java.util.List;
import org.opd.repository.*;
public class SearchDoctorServiceImple implements SearchDoctorService{
	SearchDoctorRepository sdRepo=new SearchDoctorRepositoryImple();
	public List<DoctorModule> isSearch(String n) {
		List<DoctorModule>l=sdRepo.isSearch(n);
		return l;
	}

}
