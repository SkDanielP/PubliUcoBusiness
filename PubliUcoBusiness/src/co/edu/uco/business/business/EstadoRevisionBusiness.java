package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoRevisionDomain;

public interface EstadoRevisionBusiness {
	
	void register(EstadoRevisionDomain domain);
	
	List<EstadoRevisionDomain> list(EstadoRevisionDomain domain);
	
	void modify(EstadoRevisionDomain domain);
	
	void drop(EstadoRevisionDomain domain);

}