package org.opd.repository;

import java.util.List;

import org.opd.module.PatientModule;

public interface SearchRepository {
	public List<PatientModule> isSearch(String n);
	
}
