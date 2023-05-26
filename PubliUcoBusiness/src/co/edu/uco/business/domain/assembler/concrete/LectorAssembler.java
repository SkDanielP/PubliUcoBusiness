package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.LectorDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.LectorDTO;
import co.edu.uco.publiuco.entities.LectorEntity;

public class LectorAssembler implements Assembler<LectorDomain, LectorDTO, LectorEntity> {
	
	private static final LectorAssembler INSTANCE = new LectorAssembler();

    private LectorAssembler() {
        super();
    }

    public static LectorAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public LectorDTO toDtoFromDomain(LectorDomain domain) {
        return LectorDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setTipoIdentificacion(TipoIdentificacionAssembler.getInstance().toDtoFromDomain(domain.getTipoIdentificacion()))
                .setNumeroIdentificacion(domain.getNumeroIdentificacion())
                .setNombre(domain.getNombre())
                .setTipoRelacionInstitucion(TipoRelacionInstitucionAssembler.getInstance().toDtoFromDomain(domain.getTipoRelacionInstitucion()));
    }

    @Override
    public LectorDomain toDomainFromDto(LectorDTO dto) {
        return new LectorDomain(
                dto.getIdentificador(),
                TipoIdentificacionAssembler.getInstance().toDomainFromDto(dto.getTipoIdentificacion()),
                dto.getNumeroIdentificacion(),
                dto.getNombre(),
                TipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto.getTipoRelacionInstitucion())
        );
    }

    @Override
    public LectorEntity toEntityFromDomain(LectorDomain domain) {
        return new LectorEntity(
                domain.getIdentificador(),
                TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacion()),
                domain.getNumeroIdentificacion(),
                domain.getNombre(),
                TipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain.getTipoRelacionInstitucion())
        );
    }

    @Override
    public LectorDomain toDomainFromEntity(LectorEntity entity) {
        return new LectorDomain(
                entity.getIdentificador(),
                TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacion()),
                entity.getNumeroIdentificacion(),
                entity.getNombre(),
                TipoRelacionInstitucionAssembler.getInstance().toDomainFromEntity(entity.getTipoRelacionInstitucion())
        );
    }

    @Override
    public List<LectorDomain> toDomainListFromEntities(List<LectorEntity> entityList) {
        return entityList.stream()
                .map(this::toDomainFromEntity)
                .collect(Collectors.toList());
    }

}
