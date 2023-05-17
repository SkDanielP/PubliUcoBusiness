package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoAdministradorCategoriaDomain;

public interface EstadoAdministradoCategoriaBusiness {
	
	void register(EstadoAdministradorCategoriaDomain domain);
	
	List<EstadoAdministradorCategoriaDomain> list(EstadoAdministradorCategoriaDomain domain);
	
	void modify(EstadoAdministradorCategoriaDomain domain);
	
	void drop(EstadoAdministradorCategoriaDomain domain);

}