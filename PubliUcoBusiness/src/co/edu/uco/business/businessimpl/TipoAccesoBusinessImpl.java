package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.TipoAccesoBusiness;
import co.edu.uco.business.domain.TipoAccesoDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoAccesoAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoAccesoEntity;

public final class TipoAccesoBusinessImpl implements TipoAccesoBusiness {
	
	private DAOFactory daoFactory;
	
	public TipoAccesoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoAccesoDomain domain) {
		TipoAccesoEntity entity = TipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoAccesoDAO().create(entity);
	}

	@Override
	public List<TipoAccesoDomain> list(TipoAccesoDomain domain) {
		TipoAccesoEntity entity = TipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		List<TipoAccesoEntity> result = daoFactory.getTipoAccesoDAO().read(entity);
		return null;
	}

	@Override
	public void modify(TipoAccesoDomain domain) {
		TipoAccesoEntity entity = TipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoAccesoDAO().update(entity);
	}

	@Override
	public void drop(TipoAccesoDomain domain) {
		TipoAccesoEntity entity = TipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoAccesoDAO().delete(entity);
	}
}
