

package org.opd.repository;

import java.util.List;

import org.opd.module.DoctorModule;

public interface SearchDoctorRepository {
	public List<DoctorModule> isSearch(String n);
}
