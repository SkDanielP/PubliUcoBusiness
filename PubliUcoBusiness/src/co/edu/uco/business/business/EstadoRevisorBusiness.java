package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoRevisorDomain;

public interface EstadoRevisorBusiness {
	
	void register(EstadoRevisorDomain domain);
	
	List<EstadoRevisorDomain> list(EstadoRevisorDomain domain);
	
	void modify(EstadoRevisorDomain domain);
	
	void drop(EstadoRevisorDomain domain);

}