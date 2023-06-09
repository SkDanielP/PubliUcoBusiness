package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.CalificacionDomain;

public interface CalificacionBusiness {
	
	void register(CalificacionDomain domain);
	
	List<CalificacionDomain> list(CalificacionDomain domain);
	
	void modify(CalificacionDomain domain);
	
	void drop(CalificacionDomain domain);

}
