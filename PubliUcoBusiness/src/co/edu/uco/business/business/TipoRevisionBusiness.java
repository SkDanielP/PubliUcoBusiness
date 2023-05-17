package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.TipoRevisionDomain;

public interface TipoRevisionBusiness {
	
	void register(TipoRevisionDomain domain);
	
	List<TipoRevisionDomain> list(TipoRevisionDomain domain);
	
	void modify(TipoRevisionDomain domain);
	
	void drop(TipoRevisionDomain domain);

}
