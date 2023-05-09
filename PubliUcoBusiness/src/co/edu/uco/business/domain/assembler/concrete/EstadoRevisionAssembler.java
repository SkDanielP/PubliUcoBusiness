package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoRevisionDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoRevisionDTO;
import co.edu.uco.publiuco.entities.EstadoRevisionEntity;

public final class EstadoRevisionAssembler
        implements Assembler<EstadoRevisionDomain, EstadoRevisionDTO, EstadoRevisionEntity> {

    private static final EstadoRevisionAssembler INSTANCE = new EstadoRevisionAssembler();

    private EstadoRevisionAssembler() {
        super();
    }

    public static final EstadoRevisionAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoRevisionDTO toDtoFromDomain(EstadoRevisionDomain domain) {
        return EstadoRevisionDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoRevisionDomain toDomainFromDto(EstadoRevisionDTO dto) {
        return new EstadoRevisionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoRevisionEntity toEntityFromDomain(EstadoRevisionDomain domain) {
        return new EstadoRevisionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoRevisionDomain toDomainFromEntity(EstadoRevisionEntity entity) {
        return new EstadoRevisionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoRevisionDomain> toDomainListFromEntities(List<EstadoRevisionEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
