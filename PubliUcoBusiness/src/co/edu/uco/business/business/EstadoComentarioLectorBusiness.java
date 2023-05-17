package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoComentarioLectorDomain;

public interface EstadoComentarioLectorBusiness {
	
	void register(EstadoComentarioLectorDomain domain);
	
	List<EstadoComentarioLectorDomain> list(EstadoComentarioLectorDomain domain);
	
	void modify(EstadoComentarioLectorDomain domain);
	
	void drop(EstadoComentarioLectorDomain domain);

}
