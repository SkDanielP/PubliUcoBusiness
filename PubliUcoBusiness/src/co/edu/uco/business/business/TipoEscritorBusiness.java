package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.TipoEscritorDomain;

public interface TipoEscritorBusiness {
	
	void register(TipoEscritorDomain domain);
	
	List<TipoEscritorDomain> list(TipoEscritorDomain domain);
	
	void modify(TipoEscritorDomain domain);
	
	void drop(TipoEscritorDomain domain);

}