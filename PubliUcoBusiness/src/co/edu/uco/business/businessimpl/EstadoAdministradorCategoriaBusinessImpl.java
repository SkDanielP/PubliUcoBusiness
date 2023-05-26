package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoAdministradoCategoriaBusiness;
import co.edu.uco.business.domain.EstadoAdministradorCategoriaDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoAdministradorCategoriaAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoAdministradorCategoriaEntity;

public final class EstadoAdministradorCategoriaBusinessImpl implements EstadoAdministradoCategoriaBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoAdministradorCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoAdministradorCategoriaDomain domain) {
		EstadoAdministradorCategoriaEntity entity = EstadoAdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getAdministradorCategoriaDAO().create(entity);
	}

	@Override
	public List<EstadoAdministradorCategoriaDomain> list(EstadoAdministradorCategoriaDomain domain) {
		EstadoAdministradorCategoriaEntity entity = EstadoAdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoAdministradorCategoriaEntity> result = daoFactory.getAdministradorCategoriaDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoAdministradorCategoriaDomain domain) {
		EstadoAdministradorCategoriaEntity entity = EstadoAdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getAdministradorCategoriaDAO().update(entity);
	}

	@Override
	public void drop(EstadoAdministradorCategoriaDomain domain) {
		EstadoAdministradorCategoriaEntity entity = EstadoAdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getAdministradorCategoriaDAO().delete(entity);
	}
}