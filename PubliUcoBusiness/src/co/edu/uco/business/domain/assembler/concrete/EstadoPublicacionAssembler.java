package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoPublicacionDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoPublicacionDTO;
import co.edu.uco.publiuco.entities.EstadoPublicacionEntity;

public final class EstadoPublicacionAssembler
        implements Assembler<EstadoPublicacionDomain, EstadoPublicacionDTO, EstadoPublicacionEntity> {

    private static final EstadoPublicacionAssembler INSTANCE = new EstadoPublicacionAssembler();

    private EstadoPublicacionAssembler() {
        super();
    }

    public static final EstadoPublicacionAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoPublicacionDTO toDtoFromDomain(EstadoPublicacionDomain domain) {
        return EstadoPublicacionDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoPublicacionDomain toDomainFromDto(EstadoPublicacionDTO dto) {
        return new EstadoPublicacionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoPublicacionEntity toEntityFromDomain(EstadoPublicacionDomain domain) {
        return new EstadoPublicacionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoPublicacionDomain toDomainFromEntity(EstadoPublicacionEntity entity) {
        return new EstadoPublicacionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoPublicacionDomain> toDomainListFromEntities(List<EstadoPublicacionEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
