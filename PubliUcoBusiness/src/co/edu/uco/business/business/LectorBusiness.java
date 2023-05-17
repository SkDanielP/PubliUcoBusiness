package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.LectorDomain;

public interface LectorBusiness {
	
	void register(LectorDomain domain);
	
	List<LectorDomain> list(LectorDomain domain);
	
	void modify(LectorDomain domain);
	
	void drop(LectorDomain domain);

}
