package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoLectorDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoLectorDTO;
import co.edu.uco.publiuco.entities.EstadoLectorEntity;

public final class EstadoLectorAssembler
        implements Assembler<EstadoLectorDomain, EstadoLectorDTO, EstadoLectorEntity> {

    private static final EstadoLectorAssembler INSTANCE = new EstadoLectorAssembler();

    private EstadoLectorAssembler() {
        super();
    }

    public static final EstadoLectorAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoLectorDTO toDtoFromDomain(EstadoLectorDomain domain) {
        return EstadoLectorDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoLectorDomain toDomainFromDto(EstadoLectorDTO dto) {
        return new EstadoLectorDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoLectorEntity toEntityFromDomain(EstadoLectorDomain domain) {
        return new EstadoLectorEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoLectorDomain toDomainFromEntity(EstadoLectorEntity entity) {
        return new EstadoLectorDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoLectorDomain> toDomainListFromEntities(List<EstadoLectorEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
