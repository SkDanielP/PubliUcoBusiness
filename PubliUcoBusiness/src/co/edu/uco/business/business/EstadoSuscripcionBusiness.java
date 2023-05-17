package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoSuscripcionDomain;

public interface EstadoSuscripcionBusiness {
	
	void register(EstadoSuscripcionDomain domain);
	
	List<EstadoSuscripcionDomain> list(EstadoSuscripcionDomain domain);
	
	void modify(EstadoSuscripcionDomain domain);
	
	void drop(EstadoSuscripcionDomain domain);

}
