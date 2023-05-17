package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoEscritorBusiness;
import co.edu.uco.business.domain.EstadoEscritorDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoEscritorAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoEscritorEntity;

public final class EstadoEscritorBusinessImpl implements EstadoEscritorBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoEscritorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoEscritorDomain domain) {
		EstadoEscritorEntity entity = EstadoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoEscritorDAO().create(entity);
	}

	@Override
	public List<EstadoEscritorDomain> list(EstadoEscritorDomain domain) {
		EstadoEscritorEntity entity = EstadoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoEscritorEntity> result = daoFactory.getEstadoEscritorDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoEscritorDomain domain) {
		EstadoEscritorEntity entity = EstadoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoEscritorDAO().update(entity);
	}

	@Override
	public void drop(EstadoEscritorDomain domain) {
		EstadoEscritorEntity entity = EstadoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoEscritorDAO().delete(entity);
	}
}