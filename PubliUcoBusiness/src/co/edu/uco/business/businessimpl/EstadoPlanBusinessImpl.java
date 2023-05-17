package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoPlanBusiness;
import co.edu.uco.business.domain.EstadoPlanDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoPlanAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoPlanEntity;

public final class EstadoPlanBusinessImpl implements EstadoPlanBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoPlanBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoPlanDomain domain) {
		EstadoPlanEntity entity = EstadoPlanAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoPlanDAO().create(entity);
	}

	@Override
	public List<EstadoPlanDomain> list(EstadoPlanDomain domain) {
		EstadoPlanEntity entity = EstadoPlanAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoPlanEntity> result = daoFactory.getEstadoPlanDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoPlanDomain domain) {
		EstadoPlanEntity entity = EstadoPlanAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoPlanDAO().update(entity);
	}

	@Override
	public void drop(EstadoPlanDomain domain) {
		EstadoPlanEntity entity = EstadoPlanAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoPlanDAO().delete(entity);
	}
}