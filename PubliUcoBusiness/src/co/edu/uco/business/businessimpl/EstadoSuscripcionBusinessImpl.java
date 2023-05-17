package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoSuscripcionBusiness;
import co.edu.uco.business.domain.EstadoSuscripcionDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoSuscripcionAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoSuscripcionEntity;

public final class EstadoSuscripcionBusinessImpl implements EstadoSuscripcionBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoSuscripcionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoSuscripcionDomain domain) {
		EstadoSuscripcionEntity entity = EstadoSuscripcionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoSuscripcionDAO().create(entity);
	}

	@Override
	public List<EstadoSuscripcionDomain> list(EstadoSuscripcionDomain domain) {
		EstadoSuscripcionEntity entity = EstadoSuscripcionAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoSuscripcionEntity> result = daoFactory.getEstadoSuscripcionDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoSuscripcionDomain domain) {
		EstadoSuscripcionEntity entity = EstadoSuscripcionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoSuscripcionDAO().update(entity);
	}

	@Override
	public void drop(EstadoSuscripcionDomain domain) {
		EstadoSuscripcionEntity entity = EstadoSuscripcionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoSuscripcionDAO().delete(entity);
	}
}