package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.CalificacionBusiness;
import co.edu.uco.business.domain.CalificacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.CalificacionEntity;

public final class CalificacionBusinessImpl implements CalificacionBusiness {
	
	private DAOFactory daoFactory;
	
	public CalificacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(CalificacionDomain domain) {
		CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCalificacionDAO().create(entity);
	}

	@Override
	public List<CalificacionDomain> list(CalificacionDomain domain) {
		CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);
		List<CalificacionEntity> result = daoFactory.getCalificacionDAO().read(entity);
		return null;
	}

	@Override
	public void modify(CalificacionDomain domain) {
		CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCalificacionDAO().update(entity);
	}

	@Override
	public void drop(CalificacionDomain domain) {
		CalificacionEntity entity = CalificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCalificacionDAO().delete(entity);
	}
}