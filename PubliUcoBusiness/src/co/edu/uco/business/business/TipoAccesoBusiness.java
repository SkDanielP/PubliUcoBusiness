package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.TipoAccesoDomain;

public interface TipoAccesoBusiness {
	
	void register(TipoAccesoDomain domain);
	
	List<TipoAccesoDomain> list(TipoAccesoDomain domain);
	
	void modify(TipoAccesoDomain domain);
	
	void drop(TipoAccesoDomain domain);

}
