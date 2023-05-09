package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoPlanDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoPlanDTO;
import co.edu.uco.publiuco.entities.EstadoPlanEntity;

public final class EstadoPlanAssembler
        implements Assembler<EstadoPlanDomain, EstadoPlanDTO, EstadoPlanEntity> {

    private static final EstadoPlanAssembler INSTANCE = new EstadoPlanAssembler();

    private EstadoPlanAssembler() {
        super();
    }

    public static final EstadoPlanAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoPlanDTO toDtoFromDomain(EstadoPlanDomain domain) {
        return EstadoPlanDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoPlanDomain toDomainFromDto(EstadoPlanDTO dto) {
        return new EstadoPlanDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoPlanEntity toEntityFromDomain(EstadoPlanDomain domain) {
        return new EstadoPlanEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoPlanDomain toDomainFromEntity(EstadoPlanEntity entity) {
        return new EstadoPlanDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoPlanDomain> toDomainListFromEntities(List<EstadoPlanEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
