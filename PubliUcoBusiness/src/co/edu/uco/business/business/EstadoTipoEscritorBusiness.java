package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoTipoEscritorDomain;

public interface EstadoTipoEscritorBusiness {
	
	void register(EstadoTipoEscritorDomain domain);
	
	List<EstadoTipoEscritorDomain> list(EstadoTipoEscritorDomain domain);
	
	void modify(EstadoTipoEscritorDomain domain);
	
	void drop(EstadoTipoEscritorDomain domain);

}