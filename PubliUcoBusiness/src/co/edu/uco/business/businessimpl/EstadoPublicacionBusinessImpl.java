package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoPublicacionBusiness;
import co.edu.uco.business.domain.EstadoPublicacionDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoPublicacionAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoPublicacionEntity;

public final class EstadoPublicacionBusinessImpl implements EstadoPublicacionBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoPublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoPublicacionDomain domain) {
		EstadoPublicacionEntity entity = EstadoPublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoPublicacionDAO().create(entity);
	}

	@Override
	public List<EstadoPublicacionDomain> list(EstadoPublicacionDomain domain) {
		EstadoPublicacionEntity entity = EstadoPublicacionAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoPublicacionEntity> result = daoFactory.getEstadoPublicacionDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoPublicacionDomain domain) {
		EstadoPublicacionEntity entity = EstadoPublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoPublicacionDAO().update(entity);
	}

	@Override
	public void drop(EstadoPublicacionDomain domain) {
		EstadoPublicacionEntity entity = EstadoPublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoPublicacionDAO().delete(entity);
	}
}
