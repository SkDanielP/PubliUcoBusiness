package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoCategoriaBusiness;
import co.edu.uco.business.domain.EstadoCategoriaDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoCategoriaAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoCategoriaEntity;

public final class EstadoCategoriaBusinessImpl implements EstadoCategoriaBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoCategoriaDomain domain) {
		EstadoCategoriaEntity entity = EstadoCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoCategoriaDAO().create(entity);
	}

	@Override
	public List<EstadoCategoriaDomain> list(EstadoCategoriaDomain domain) {
		EstadoCategoriaEntity entity = EstadoCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoCategoriaEntity> result = daoFactory.getEstadoCategoriaDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoCategoriaDomain domain) {
		EstadoCategoriaEntity entity = EstadoCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoCategoriaDAO().update(entity);
	}

	@Override
	public void drop(EstadoCategoriaDomain domain) {
		EstadoCategoriaEntity entity = EstadoCategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoCategoriaDAO().delete(entity);
	}
}