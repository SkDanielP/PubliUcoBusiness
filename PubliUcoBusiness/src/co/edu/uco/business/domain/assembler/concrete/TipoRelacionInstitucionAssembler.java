package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;

import co.edu.uco.business.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public final class TipoRelacionInstitucionAssembler
        implements Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO, TipoRelacionInstitucionEntity> {

    private static final TipoRelacionInstitucionAssembler INSTANCE = new TipoRelacionInstitucionAssembler();

    private TipoRelacionInstitucionAssembler() {
        super();
    }

    public static TipoRelacionInstitucionAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public TipoRelacionInstitucionDTO toDtoFromDomain(TipoRelacionInstitucionDomain domain) {
        return TipoRelacionInstitucionDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
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

	@Override
	public List<TipoRelacionInstitucionDomain> toDomainListFromEntities(
			List<TipoRelacionInstitucionEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
