package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoTipoEscritorDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoTipoEscritorDTO;
import co.edu.uco.publiuco.entities.EstadoTipoEscritorEntity;

public final class EstadoTipoEscritorAssembler
        implements Assembler<EstadoTipoEscritorDomain, EstadoTipoEscritorDTO, EstadoTipoEscritorEntity> {

    private static final EstadoTipoEscritorAssembler INSTANCE = new EstadoTipoEscritorAssembler();

    private EstadoTipoEscritorAssembler() {
        super();
    }

    public static final EstadoTipoEscritorAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoTipoEscritorDTO toDtoFromDomain(EstadoTipoEscritorDomain domain) {
        return EstadoTipoEscritorDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoTipoEscritorDomain toDomainFromDto(EstadoTipoEscritorDTO dto) {
        return new EstadoTipoEscritorDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoTipoEscritorEntity toEntityFromDomain(EstadoTipoEscritorDomain domain) {
        return new EstadoTipoEscritorEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoTipoEscritorDomain toDomainFromEntity(EstadoTipoEscritorEntity entity) {
        return new EstadoTipoEscritorDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoTipoEscritorDomain> toDomainListFromEntities(List<EstadoTipoEscritorEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
