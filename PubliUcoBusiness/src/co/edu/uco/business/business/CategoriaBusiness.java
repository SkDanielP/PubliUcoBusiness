package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.CategoriaDomain;

public interface CategoriaBusiness {
	
	void register(CategoriaDomain domain);
	
	List<CategoriaDomain> list(CategoriaDomain domain);
	
	void modify(CategoriaDomain domain);
	
	void drop(CategoriaDomain domain);

}
