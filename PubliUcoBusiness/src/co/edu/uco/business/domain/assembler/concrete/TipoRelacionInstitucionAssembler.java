package co.edu.uco.business.domain.assembler.concrete;


import co.edu.uco.business.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;


public final class TipoRelacionInstitucionAssembler implements Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO, TipoRelacionInstitucionEntity> {

	@Override
	public TipoRelacionInstitucionDTO toDtoFromDomain(TipoRelacionInstitucionDomain domain) {
		return TipoRelacionInstitucionDTO.create().setIdentificador(domain.getIdentificador()).
				setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion()).setEstado(EstadoTipoRelacionInstitucionAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	}

	@Override
	public TipoRelacionInstitucionDomain toDomainFromDto(TipoRelacionInstitucionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoRelacionInstitucionEntity toEntityFromDomain(TipoRelacionInstitucionDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoRelacionInstitucionDomain toDomainFromEntity(TipoRelacionInstitucionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
