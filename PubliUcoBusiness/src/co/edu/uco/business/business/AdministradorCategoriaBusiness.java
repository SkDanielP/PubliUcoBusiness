package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.AdministradorCategoriaDomain;

public interface AdministradorCategoriaBusiness {
	
	void register(AdministradorCategoriaDomain domain);
	
	List<AdministradorCategoriaDomain> list(AdministradorCategoriaDomain domain);
	
	void modify(AdministradorCategoriaDomain domain);
	
	void drop(AdministradorCategoriaDomain domain);

}
