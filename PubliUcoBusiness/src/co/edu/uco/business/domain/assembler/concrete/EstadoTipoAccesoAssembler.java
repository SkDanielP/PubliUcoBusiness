package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoTipoAccesoDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoTipoAccesoDTO;
import co.edu.uco.publiuco.entities.EstadoTipoAccesoEntity;

public final class EstadoTipoAccesoAssembler
        implements Assembler<EstadoTipoAccesoDomain, EstadoTipoAccesoDTO, EstadoTipoAccesoEntity> {

    private static final EstadoTipoAccesoAssembler INSTANCE = new EstadoTipoAccesoAssembler();

    private EstadoTipoAccesoAssembler() {
        super();
    }

    public static final EstadoTipoAccesoAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoTipoAccesoDTO toDtoFromDomain(EstadoTipoAccesoDomain domain) {
        return EstadoTipoAccesoDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoTipoAccesoDomain toDomainFromDto(EstadoTipoAccesoDTO dto) {
        return new EstadoTipoAccesoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoTipoAccesoEntity toEntityFromDomain(EstadoTipoAccesoDomain domain) {
        return new EstadoTipoAccesoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoTipoAccesoDomain toDomainFromEntity(EstadoTipoAccesoEntity entity) {
        return new EstadoTipoAccesoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoTipoAccesoDomain> toDomainListFromEntities(List<EstadoTipoAccesoEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
