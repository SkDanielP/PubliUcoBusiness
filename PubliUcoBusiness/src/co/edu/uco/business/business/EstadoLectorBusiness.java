package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoLectorDomain;

public interface EstadoLectorBusiness {
	
	void register(EstadoLectorDomain domain);
	
	List<EstadoLectorDomain> list(EstadoLectorDomain domain);
	
	void modify(EstadoLectorDomain domain);
	
	void drop(EstadoLectorDomain domain);

}
