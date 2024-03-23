package org.opd.service;
import java.util.List;
import org.opd.module.DoctorModule;
public interface SearchDoctorService {
	public List<DoctorModule> isSearch(String n);
}
