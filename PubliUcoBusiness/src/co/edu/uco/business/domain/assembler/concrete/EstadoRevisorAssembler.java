package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoRevisorDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoRevisorDTO;
import co.edu.uco.publiuco.entities.EstadoRevisorEntity;

public final class EstadoRevisorAssembler
        implements Assembler<EstadoRevisorDomain, EstadoRevisorDTO, EstadoRevisorEntity> {

    private static final EstadoRevisorAssembler INSTANCE = new EstadoRevisorAssembler();

    private EstadoRevisorAssembler() {
        super();
    }

    public static final EstadoRevisorAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoRevisorDTO toDtoFromDomain(EstadoRevisorDomain domain) {
        return EstadoRevisorDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoRevisorDomain toDomainFromDto(EstadoRevisorDTO dto) {
        return new EstadoRevisorDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoRevisorEntity toEntityFromDomain(EstadoRevisorDomain domain) {
        return new EstadoRevisorEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoRevisorDomain toDomainFromEntity(EstadoRevisorEntity entity) {
        return new EstadoRevisorDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoRevisorDomain> toDomainListFromEntities(List<EstadoRevisorEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
