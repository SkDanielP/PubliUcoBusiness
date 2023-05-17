package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoObservacionRevisorDomain;

public interface EstadoObservacionRevisorBusiness {
	
	void register(EstadoObservacionRevisorDomain domain);
	
	List<EstadoObservacionRevisorDomain> list(EstadoObservacionRevisorDomain domain);
	
	void modify(EstadoObservacionRevisorDomain domain);
	
	void drop(EstadoObservacionRevisorDomain domain);

}
