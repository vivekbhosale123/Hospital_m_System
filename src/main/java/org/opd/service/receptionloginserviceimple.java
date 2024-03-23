package org.opd.service;
import org.opd.repository.*;
import org.opd.module.receptionloginmodule;
public class receptionloginserviceimple implements receptionlogiincervice{
	receptionloginrepository repo=new receptionlologinrepositoryimple();
	public boolean isValidate(receptionloginmodule rl) {
		String p=rl.getPassword();
		int l=p.length();
		if(l>5)
		{
			//call database layer or repository layer
			//boolean b=repo.isValidate(rl);
			//return b;
			//return repo.isValidate(rl);
		}
		else
		{
			return false;
		}
		/*return rl.getPassword().length()>5?true:false;*/
		return rl.getPassword().length()>5?repo.isValidate(rl):false;
	}
  
}
