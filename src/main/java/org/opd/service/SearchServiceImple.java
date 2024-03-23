package org.opd.service;
import org.opd.repository.*;
import java.util.List;
import org.opd.module.*;
public class SearchServiceImple implements SearchService{
	SearchRepository sRepo= new SearchRepositoryImple();
	public List<PatientModule> isSearch(String n) {
		List<PatientModule>l=sRepo.isSearch(n);
		
		return l;
	}

}
