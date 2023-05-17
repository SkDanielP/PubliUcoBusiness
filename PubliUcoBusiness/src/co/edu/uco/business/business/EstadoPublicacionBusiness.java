package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoPublicacionDomain;

public interface EstadoPublicacionBusiness {
	
	void register(EstadoPublicacionDomain domain);
	
	List<EstadoPublicacionDomain> list(EstadoPublicacionDomain domain);
	
	void modify(EstadoPublicacionDomain domain);
	
	void drop(EstadoPublicacionDomain domain);

}