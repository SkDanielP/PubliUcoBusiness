package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoEscritorDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoEscritorDTO;
import co.edu.uco.publiuco.entities.EstadoEscritorEntity;

public final class EstadoEscritorAssembler
        implements Assembler<EstadoEscritorDomain, EstadoEscritorDTO, EstadoEscritorEntity> {

    private static final EstadoEscritorAssembler INSTANCE = new EstadoEscritorAssembler();

    private EstadoEscritorAssembler() {
        super();
    }

    public static final EstadoEscritorAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoEscritorDTO toDtoFromDomain(EstadoEscritorDomain domain) {
        return EstadoEscritorDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoEscritorDomain toDomainFromDto(EstadoEscritorDTO dto) {
        return new EstadoEscritorDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoEscritorEntity toEntityFromDomain(EstadoEscritorDomain domain) {
        return new EstadoEscritorEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoEscritorDomain toDomainFromEntity(EstadoEscritorEntity entity) {
        return new EstadoEscritorDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoEscritorDomain> toDomainListFromEntities(List<EstadoEscritorEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
