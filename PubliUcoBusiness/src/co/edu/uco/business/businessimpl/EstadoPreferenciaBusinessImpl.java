package co.edu.uco.business.businessimpl;

import java.util.List;

import co.edu.uco.business.business.EstadoPreferenciaBusiness;
import co.edu.uco.business.domain.EstadoPreferenciaDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoPreferenciaAssembler;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoPreferenciaEntity;

public final class EstadoPreferenciaBusinessImpl implements EstadoPreferenciaBusiness {
	
	private DAOFactory daoFactory;
	
	public EstadoPreferenciaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EstadoPreferenciaDomain domain) {
		EstadoPreferenciaEntity entity = EstadoPreferenciaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoPreferenciaDAO().create(entity);
	}

	@Override
	public List<EstadoPreferenciaDomain> list(EstadoPreferenciaDomain domain) {
		EstadoPreferenciaEntity entity = EstadoPreferenciaAssembler.getInstance().toEntityFromDomain(domain);
		List<EstadoPreferenciaEntity> result = daoFactory.getEstadoPreferenciaDAO().read(entity);
		return null;
	}

	@Override
	public void modify(EstadoPreferenciaDomain domain) {
		EstadoPreferenciaEntity entity = EstadoPreferenciaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoPreferenciaDAO().update(entity);
	}

	@Override
	public void drop(EstadoPreferenciaDomain domain) {
		EstadoPreferenciaEntity entity = EstadoPreferenciaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoPreferenciaDAO().delete(entity);
	}
}
