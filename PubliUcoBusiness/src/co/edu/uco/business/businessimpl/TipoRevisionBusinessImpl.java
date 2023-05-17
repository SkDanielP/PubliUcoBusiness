package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.TipoRevisionBusiness;
import co.edu.uco.business.domain.TipoRevisionDomain;
import co.edu.uco.business.domain.assembler.concrete.TipoRevisionAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoRevisionEntity;

public final class TipoRevisionBusinessImpl implements TipoRevisionBusiness {
	
	private DAOFactory daoFactory;
	
	public TipoRevisionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoRevisionDomain domain) {
		TipoRevisionEntity entity = TipoRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoRevisionDAO().create(entity);
	}

	@Override
	public List<TipoRevisionDomain> list(TipoRevisionDomain domain) {
		TipoRevisionEntity entity = TipoRevisionAssembler.getInstance().toEntityFromDomain(domain);
		List<TipoRevisionEntity> result = daoFactory.getTipoRevisionDAO().read(entity);
		return null;
	}

	@Override
	public void modify(TipoRevisionDomain domain) {
		TipoRevisionEntity entity = TipoRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoRevisionDAO().update(entity);
	}

	@Override
	public void drop(TipoRevisionDomain domain) {
		TipoRevisionEntity entity = TipoRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoRevisionDAO().delete(entity);
	}
}