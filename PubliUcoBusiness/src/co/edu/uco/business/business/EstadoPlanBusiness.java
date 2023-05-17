package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoPlanDomain;

public interface EstadoPlanBusiness {
	
	void register(EstadoPlanDomain domain);
	
	List<EstadoPlanDomain> list(EstadoPlanDomain domain);
	
	void modify(EstadoPlanDomain domain);
	
	void drop(EstadoPlanDomain domain);

}