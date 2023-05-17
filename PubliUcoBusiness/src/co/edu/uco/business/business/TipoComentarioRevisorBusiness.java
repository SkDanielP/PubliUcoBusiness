package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.TipoComentarioRevisorDomain;

public interface TipoComentarioRevisorBusiness {
	
	void register(TipoComentarioRevisorDomain domain);
	
	List<TipoComentarioRevisorDomain> list(TipoComentarioRevisorDomain domain);
	
	void modify(TipoComentarioRevisorDomain domain);
	
	void drop(TipoComentarioRevisorDomain domain);

}