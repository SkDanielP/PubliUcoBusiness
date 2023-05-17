package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.PublicacionBusiness;
import co.edu.uco.business.domain.PublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PublicacionEntity;

public final class PublicacionBusinessImpl implements PublicacionBusiness {
	
	private DAOFactory daoFactory;
	
	public PublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(PublicacionDomain domain) {
		PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPublicacionDAO().create(entity);
	}

	@Override
	public List<PublicacionDomain> list(PublicacionDomain domain) {
		PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);
		List<PublicacionEntity> result = daoFactory.getPublicacionDAO().read(entity);
		return null;
	}

	@Override
	public void modify(PublicacionDomain domain) {
		PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPublicacionDAO().update(entity);
	}

	@Override
	public void drop(PublicacionDomain domain) {
		PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPublicacionDAO().delete(entity);
	}
}