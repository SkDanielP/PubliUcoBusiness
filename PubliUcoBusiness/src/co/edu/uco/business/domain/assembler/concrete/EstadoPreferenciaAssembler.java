package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoPreferenciaDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoPreferenciaDTO;
import co.edu.uco.publiuco.entities.EstadoPreferenciaEntity;

public final class EstadoPreferenciaAssembler
        implements Assembler<EstadoPreferenciaDomain, EstadoPreferenciaDTO, EstadoPreferenciaEntity> {

    private static final EstadoPreferenciaAssembler INSTANCE = new EstadoPreferenciaAssembler();

    private EstadoPreferenciaAssembler() {
        super();
    }

    public static final EstadoPreferenciaAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoPreferenciaDTO toDtoFromDomain(EstadoPreferenciaDomain domain) {
        return EstadoPreferenciaDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoPreferenciaDomain toDomainFromDto(EstadoPreferenciaDTO dto) {
        return new EstadoPreferenciaDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoPreferenciaEntity toEntityFromDomain(EstadoPreferenciaDomain domain) {
        return new EstadoPreferenciaEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoPreferenciaDomain toDomainFromEntity(EstadoPreferenciaEntity entity) {
        return new EstadoPreferenciaDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoPreferenciaDomain> toDomainListFromEntities(List<EstadoPreferenciaEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
