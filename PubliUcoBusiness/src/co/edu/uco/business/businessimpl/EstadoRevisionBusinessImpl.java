package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoRevisionBusiness;
import co.edu.uco.business.domain.EstadoRevisionDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoRevisionAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoRevisionEntity;

public final class EstadoRevisionBusinessImpl implements EstadoRevisionBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoRevisionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoRevisionDomain domain) {
		EstadoRevisionEntity entity = EstadoRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoRevisionDAO().create(entity);
	}

	@Override
	public List<EstadoRevisionDomain> list(EstadoRevisionDomain domain) {
		EstadoRevisionEntity entity = EstadoRevisionAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoRevisionEntity> result = daoFactory.getEstadoRevisionDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoRevisionDomain domain) {
		EstadoRevisionEntity entity = EstadoRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoRevisionDAO().update(entity);
	}

	@Override
	public void drop(EstadoRevisionDomain domain) {
		EstadoRevisionEntity entity = EstadoRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoRevisionDAO().delete(entity);
	}
}
