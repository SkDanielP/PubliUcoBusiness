package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoObservacionRevisorDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoObservacionRevisorDTO;
import co.edu.uco.publiuco.entities.EstadoObservacionRevisorEntity;

public final class EstadoObservacionRevisorAssembler
        implements Assembler<EstadoObservacionRevisorDomain, EstadoObservacionRevisorDTO, EstadoObservacionRevisorEntity> {

    private static final EstadoObservacionRevisorAssembler INSTANCE = new EstadoObservacionRevisorAssembler();

    private EstadoObservacionRevisorAssembler() {
        super();
    }

    public static final EstadoObservacionRevisorAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoObservacionRevisorDTO toDtoFromDomain(EstadoObservacionRevisorDomain domain) {
        return EstadoObservacionRevisorDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoObservacionRevisorDomain toDomainFromDto(EstadoObservacionRevisorDTO dto) {
        return new EstadoObservacionRevisorDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoObservacionRevisorEntity toEntityFromDomain(EstadoObservacionRevisorDomain domain) {
        return new EstadoObservacionRevisorEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoObservacionRevisorDomain toDomainFromEntity(EstadoObservacionRevisorEntity entity) {
        return new EstadoObservacionRevisorDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoObservacionRevisorDomain> toDomainListFromEntities(List<EstadoObservacionRevisorEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
