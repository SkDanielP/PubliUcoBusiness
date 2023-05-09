package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoComentarioLectorDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoComentarioLectorDTO;
import co.edu.uco.publiuco.entities.EstadoComentarioLectorEntity;

public final class EstadoComentarioLectorAssembler
        implements Assembler<EstadoComentarioLectorDomain, EstadoComentarioLectorDTO, EstadoComentarioLectorEntity> {

    private static final EstadoComentarioLectorAssembler INSTANCE = new EstadoComentarioLectorAssembler();

    private EstadoComentarioLectorAssembler() {
        super();
    }

    public static final EstadoComentarioLectorAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoComentarioLectorDTO toDtoFromDomain(EstadoComentarioLectorDomain domain) {
        return EstadoComentarioLectorDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoComentarioLectorDomain toDomainFromDto(EstadoComentarioLectorDTO dto) {
        return new EstadoComentarioLectorDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoComentarioLectorEntity toEntityFromDomain(EstadoComentarioLectorDomain domain) {
        return new EstadoComentarioLectorEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoComentarioLectorDomain toDomainFromEntity(EstadoComentarioLectorEntity entity) {
        return new EstadoComentarioLectorDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoComentarioLectorDomain> toDomainListFromEntities(List<EstadoComentarioLectorEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
