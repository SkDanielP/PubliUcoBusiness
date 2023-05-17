package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoRevisorBusiness;
import co.edu.uco.business.domain.EstadoRevisorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoRevisorAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoRevisorEntity;

public final class EstadoRevisorBusinessImpl implements EstadoRevisorBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoRevisorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoRevisorDomain domain) {
		EstadoRevisorEntity entity = EstadoRevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoRevisorDAO().create(entity);
	}

	@Override
	public List<EstadoRevisorDomain> list(EstadoRevisorDomain domain) {
		EstadoRevisorEntity entity = EstadoRevisorAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoRevisorEntity> result = daoFactory.getEstadoRevisorDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoRevisorDomain domain) {
		EstadoRevisorEntity entity = EstadoRevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoRevisorDAO().update(entity);
	}

	@Override
	public void drop(EstadoRevisorDomain domain) {
		EstadoRevisorEntity entity = EstadoRevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoRevisorDAO().delete(entity);
	}
}
