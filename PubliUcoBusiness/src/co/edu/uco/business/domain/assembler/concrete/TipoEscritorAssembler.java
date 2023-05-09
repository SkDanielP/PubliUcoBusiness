package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.TipoEscritorDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.TipoEscritorDTO;
import co.edu.uco.publiuco.entities.TipoEscritorEntity;

public final class TipoEscritorAssembler
        implements Assembler<TipoEscritorDomain, TipoEscritorDTO, TipoEscritorEntity> {

    private static final TipoEscritorAssembler INSTANCE = new TipoEscritorAssembler();

    private TipoEscritorAssembler() {
        super();
    }

    public static final TipoEscritorAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public TipoEscritorDTO toDtoFromDomain(TipoEscritorDomain domain) {
        return TipoEscritorDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoEscritorDomain toDomainFromDto(TipoEscritorDTO dto) {
        return new TipoEscritorDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public TipoEscritorEntity toEntityFromDomain(TipoEscritorDomain domain) {
        return new TipoEscritorEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public TipoEscritorDomain toDomainFromEntity(TipoEscritorEntity entity) {
        return new TipoEscritorDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<TipoEscritorDomain> toDomainListFromEntities(List<TipoEscritorEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
