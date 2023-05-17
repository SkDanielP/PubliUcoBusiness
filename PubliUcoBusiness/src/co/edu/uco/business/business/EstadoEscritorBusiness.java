package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoEscritorDomain;

public interface EstadoEscritorBusiness {
	
	void register(EstadoEscritorDomain domain);
	
	List<EstadoEscritorDomain> list(EstadoEscritorDomain domain);
	
	void modify(EstadoEscritorDomain domain);
	
	void drop(EstadoEscritorDomain domain);

}