package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.EstadoTipoAccesoDomain;

public interface EstadoTipoAccesoBusiness {
	
	void register(EstadoTipoAccesoDomain domain);
	
	List<EstadoTipoAccesoDomain> list(EstadoTipoAccesoDomain domain);
	
	void modify(EstadoTipoAccesoDomain domain);
	
	void drop(EstadoTipoAccesoDomain domain);

}