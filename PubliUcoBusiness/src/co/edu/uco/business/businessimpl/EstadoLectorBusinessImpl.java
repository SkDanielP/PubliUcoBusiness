package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoLectorBusiness;
import co.edu.uco.business.domain.EstadoLectorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoLectorAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoLectorEntity;

public final class EstadoLectorBusinessImpl implements EstadoLectorBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoLectorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoLectorDomain domain) {
		EstadoLectorEntity entity = EstadoLectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoLectorDAO().create(entity);
	}

	@Override
	public List<EstadoLectorDomain> list(EstadoLectorDomain domain) {
		EstadoLectorEntity entity = EstadoLectorAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoLectorEntity> result = daoFactory.getEstadoLectorDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoLectorDomain domain) {
		EstadoLectorEntity entity = EstadoLectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoLectorDAO().update(entity);
	}

	@Override
	public void drop(EstadoLectorDomain domain) {
		EstadoLectorEntity entity = EstadoLectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoLectorDAO().delete(entity);
	}
}

