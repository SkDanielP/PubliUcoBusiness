package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.LectorBusiness;
import co.edu.uco.business.domain.LectorDomain;
import co.edu.uco.business.domain.assembler.concrete.LectorAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.LectorEntity;

public final class LectorBusinessImpl implements LectorBusiness {
	
	private DAOFactory daoFactory;
	
	public LectorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(LectorDomain domain) {
		LectorEntity entity = LectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getLectorDAO().create(entity);
	}

	@Override
	public List<LectorDomain> list(LectorDomain domain) {
		LectorEntity entity = LectorAssembler.getInstance().toEntityFromDomain(domain);
		List<LectorEntity> result = daoFactory.getLectorDAO().read(entity);
		return LectorAssembler.getInstance().toDomainList(result);
	}

	@Override
	public void modify(LectorDomain domain) {
		LectorEntity entity = LectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getLectorDAO().update(entity);
	}

	@Override
	public void drop(LectorDomain domain) {
		LectorEntity entity = LectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getLectorDAO().delete(entity);
	}
}