package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.CategoriaBusiness;
import co.edu.uco.business.domain.CategoriaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.CategoriaEntity;

public final class CategoriaBusinessImpl implements CategoriaBusiness {
	
	private DAOFactory daoFactory;
	
	public CategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(CategoriaDomain domain) {
		CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().create(entity);
	}

	@Override
	public List<CategoriaDomain> list(CategoriaDomain domain) {
		CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		List<CategoriaEntity> result = daoFactory.getCategoriaDAO().read(entity);
		return null;
	}

	@Override
	public void modify(CategoriaDomain domain) {
		CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().update(entity);
	}

	@Override
	public void drop(CategoriaDomain domain) {
		CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().delete(entity);
	}
}