package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoSuscripcionDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoSuscripcionDTO;
import co.edu.uco.publiuco.entities.EstadoSuscripcionEntity;

public final class EstadoSuscripcionAssembler
        implements Assembler<EstadoSuscripcionDomain, EstadoSuscripcionDTO, EstadoSuscripcionEntity> {

    private static final EstadoSuscripcionAssembler INSTANCE = new EstadoSuscripcionAssembler();

    private EstadoSuscripcionAssembler() {
        super();
    }

    public static final EstadoSuscripcionAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoSuscripcionDTO toDtoFromDomain(EstadoSuscripcionDomain domain) {
        return EstadoSuscripcionDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoSuscripcionDomain toDomainFromDto(EstadoSuscripcionDTO dto) {
        return new EstadoSuscripcionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoSuscripcionEntity toEntityFromDomain(EstadoSuscripcionDomain domain) {
        return new EstadoSuscripcionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoSuscripcionDomain toDomainFromEntity(EstadoSuscripcionEntity entity) {
        return new EstadoSuscripcionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoSuscripcionDomain> toDomainListFromEntities(List<EstadoSuscripcionEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
