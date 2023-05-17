package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoObservacionRevisorBusiness;
import co.edu.uco.business.domain.EstadoObservacionRevisorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoObservacionRevisorAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoObservacionRevisorEntity;

public final class EstadoObservacionRevisorBusinessImpl implements EstadoObservacionRevisorBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoObservacionRevisorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoObservacionRevisorDomain domain) {
		EstadoObservacionRevisorEntity entity = EstadoObservacionRevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoObservacionRevisorDAO().create(entity);
	}

	@Override
	public List<EstadoObservacionRevisorDomain> list(EstadoObservacionRevisorDomain domain) {
		EstadoObservacionRevisorEntity entity = EstadoObservacionRevisorAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoObservacionRevisorEntity> result = daoFactory.getEstadoObservacionRevisorDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoObservacionRevisorDomain domain) {
		EstadoObservacionRevisorEntity entity = EstadoObservacionRevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoObservacionRevisorDAO().update(entity);
	}

	@Override
	public void drop(EstadoObservacionRevisorDomain domain) {
		EstadoObservacionRevisorEntity entity = EstadoObservacionRevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoObservacionRevisorDAO().delete(entity);
	}
}
