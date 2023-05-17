package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.TipoReporteBusiness;
import co.edu.uco.business.domain.TipoReporteDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoReporteAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoReporteEntity;

public final class TipoReporteBusinessImpl implements TipoReporteBusiness {
	
	private DAOFactory daoFactory;
	
	public TipoReporteBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoReporteDomain domain) {
		TipoReporteEntity entity = TipoReporteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoReporteDAO().create(entity);
	}

	@Override
	public List<TipoReporteDomain> list(TipoReporteDomain domain) {
		TipoReporteEntity entity = TipoReporteAssembler.getInstance().toEntityFromDomain(domain);
		List<TipoReporteEntity> result = daoFactory.getTipoReporteDAO().read(entity);
		return null;
	}

	@Override
	public void modify(TipoReporteDomain domain) {
		TipoReporteEntity entity = TipoReporteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoReporteDAO().update(entity);
	}

	@Override
	public void drop(TipoReporteDomain domain) {
		TipoReporteEntity entity = TipoReporteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoReporteDAO().delete(entity);
	}
}