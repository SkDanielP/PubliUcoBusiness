package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.AdministradorCategoriaBusiness;
import co.edu.uco.business.domain.AdministradorCategoriaDomain;
import co.edu.uco.business.domain.assembler.concrete.AdministradorCategoriaAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.AdministradorCategoriaEntity;

public final class AdministradorCategoriaBusinessImpl implements AdministradorCategoriaBusiness {
	
	private DAOFactory daoFactory;
	
	public AdministradorCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(AdministradorCategoriaDomain domain) {
		AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getAdministradorCategoriaDAO().create(entity);
	}

	@Override
	public List<AdministradorCategoriaDomain> list(AdministradorCategoriaDomain domain) {
		AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		List<AdministradorCategoriaEntity> result = daoFactory.getAdministradorCategoriaDAO().read(entity);
		return null;
	}

	@Override
	public void modify(AdministradorCategoriaDomain domain) {
		AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getAdministradorCategoriaDAO().update(entity);
	}

	@Override
	public void drop(AdministradorCategoriaDomain domain) {
		AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getAdministradorCategoriaDAO().delete(entity);
	}
}