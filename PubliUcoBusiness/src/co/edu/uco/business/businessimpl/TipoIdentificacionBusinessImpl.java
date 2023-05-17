package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.TipoIdentificacionBusiness;
import co.edu.uco.business.domain.TipoIdentificacionDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoIdentificacionAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoIdentificacionEntity;

public final class TipoIdentificacionBusinessImpl implements TipoIdentificacionBusiness {
	
	private DAOFactory daoFactory;
	
	public TipoIdentificacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoIdentificacionDomain domain) {
		TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoIdentificacionDAO().create(entity);
	}

	@Override
	public List<TipoIdentificacionDomain> list(TipoIdentificacionDomain domain) {
		TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain);
		List<TipoIdentificacionEntity> result = daoFactory.getTipoIdentificacionDAO().read(entity);
		return null;
	}

	@Override
	public void modify(TipoIdentificacionDomain domain) {
		TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoIdentificacionDAO().update(entity);
	}

	@Override
	public void drop(TipoIdentificacionDomain domain) {
		TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoIdentificacionDAO().delete(entity);
	}
}
