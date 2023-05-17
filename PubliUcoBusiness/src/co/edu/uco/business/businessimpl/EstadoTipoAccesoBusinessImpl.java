package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoTipoAccesoBusiness;
import co.edu.uco.business.domain.EstadoTipoAccesoDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoTipoAccesoAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoTipoAccesoEntity;

public final class EstadoTipoAccesoBusinessImpl implements EstadoTipoAccesoBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoTipoAccesoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoTipoAccesoDomain domain) {
		EstadoTipoAccesoEntity entity = EstadoTipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoAccesoDAO().create(entity);
	}

	@Override
	public List<EstadoTipoAccesoDomain> list(EstadoTipoAccesoDomain domain) {
		EstadoTipoAccesoEntity entity = EstadoTipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoTipoAccesoEntity> result = daoFactory.getEstadoTipoAccesoDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoTipoAccesoDomain domain) {
		EstadoTipoAccesoEntity entity = EstadoTipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoAccesoDAO().update(entity);
	}

	@Override
	public void drop(EstadoTipoAccesoDomain domain) {
		EstadoTipoAccesoEntity entity = EstadoTipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoAccesoDAO().delete(entity);
	}
}
