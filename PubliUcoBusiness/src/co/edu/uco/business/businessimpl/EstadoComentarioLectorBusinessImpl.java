package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoComentarioLectorBusiness;
import co.edu.uco.business.domain.EstadoComentarioLectorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoComentarioLectorAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoComentarioLectorEntity;

public final class EstadoComentarioLectorBusinessImpl implements EstadoComentarioLectorBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoComentarioLectorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoComentarioLectorDomain domain) {
		EstadoComentarioLectorEntity entity = EstadoComentarioLectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoComentarioLectorDAO().create(entity);
	}

	@Override
	public List<EstadoComentarioLectorDomain> list(EstadoComentarioLectorDomain domain) {
		EstadoComentarioLectorEntity entity = EstadoComentarioLectorAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoComentarioLectorEntity> result = daoFactory.getEstadoComentarioLectorDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoComentarioLectorDomain domain) {
		EstadoComentarioLectorEntity entity = EstadoComentarioLectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoComentarioLectorDAO().update(entity);
	}

	@Override
	public void drop(EstadoComentarioLectorDomain domain) {
		EstadoComentarioLectorEntity entity = EstadoComentarioLectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoComentarioLectorDAO().delete(entity);
	}
}