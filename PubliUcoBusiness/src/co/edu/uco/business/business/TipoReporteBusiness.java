package co.edu.uco.business.business;

import java.util.List;

import co.edu.uco.business.domain.TipoReporteDomain;

public interface TipoReporteBusiness {
	
	void register(TipoReporteDomain domain);
	
	List<TipoReporteDomain> list(TipoReporteDomain domain);
	
	void modify(TipoReporteDomain domain);
	
	void drop(TipoReporteDomain domain);

}
