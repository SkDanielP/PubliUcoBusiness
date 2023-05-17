package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoTipoEscritorBusiness;
import co.edu.uco.business.domain.EstadoTipoEscritorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoTipoEscritorAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoTipoEscritorEntity;

public final class EstadoTipoEscritorBusinessImpl implements EstadoTipoEscritorBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoTipoEscritorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoTipoEscritorDomain domain) {
		EstadoTipoEscritorEntity entity = EstadoTipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoEscritorDAO().create(entity);
	}

	@Override
	public List<EstadoTipoEscritorDomain> list(EstadoTipoEscritorDomain domain) {
		EstadoTipoEscritorEntity entity = EstadoTipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoTipoEscritorEntity> result = daoFactory.getEstadoTipoEscritorDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoTipoEscritorDomain domain) {
		EstadoTipoEscritorEntity entity = EstadoTipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoEscritorDAO().update(entity);
	}

	@Override
	public void drop(EstadoTipoEscritorDomain domain) {
		EstadoTipoEscritorEntity entity = EstadoTipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoEscritorDAO().delete(entity);
	}
}
