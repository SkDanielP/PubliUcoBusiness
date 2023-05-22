package co.edu.uco.business.businessimpl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.business.business.EstadoTipoRelacionInstitucionBusiness;
import co.edu.uco.business.domain.EstadoTipoRelacionInstitucionDomain;
import co.edu.uco.business.domain.assembler.concrete.EstadoTipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBussinesException;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public final class EstadoTipoRelacionInstitucionBusinessImpl implements EstadoTipoRelacionInstitucionBusiness{
	
	private DAOFactory daoFactory;
	
	public EstadoTipoRelacionInstitucionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public final void register(final EstadoTipoRelacionInstitucionDomain domain) {
		
		UUID identificador;
		EstadoTipoRelacionInstitucionEntity entityTmp;
		List<EstadoTipoRelacionInstitucionEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = EstadoTipoRelacionInstitucionEntity.createWithIdentificador(identificador);
			result = daoFactory.getEstadoTipoRelacionInstitucionDAO().read(entityTmp);
		} while (!result.isEmpty());

		entityTmp = EstadoTipoRelacionInstitucionEntity.createWithNombre(domain.getNombre());
		result = daoFactory.getEstadoTipoRelacionInstitucionDAO().read(entityTmp);
		
		if(!result.isEmpty()) {
			throw PubliucoBussinesException.create("El estado de tipo relacion institucion que intenta crear ya existe, Por favor verifique e intente nuevamente");
		}
		
		
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().create(entity);
		
	}

	@Override
	public final List<EstadoTipoRelacionInstitucionDomain> list(final EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain);
		final List<EstadoTipoRelacionInstitucionEntity> result = daoFactory.getEstadoTipoRelacionInstitucionDAO().read(entity);
		return null;
	}

	@Override
	public final void modify(final EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().update(entity);
		
	}

	@Override
	public final void drop(final EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().delete(entity);
	}

}
