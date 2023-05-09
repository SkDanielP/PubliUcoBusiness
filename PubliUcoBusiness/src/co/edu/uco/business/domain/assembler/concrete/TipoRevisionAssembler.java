package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.TipoRevisionDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.TipoRevisionDTO;
import co.edu.uco.publiuco.entities.TipoRevisionEntity;

public final class TipoRevisionAssembler
        implements Assembler<TipoRevisionDomain, TipoRevisionDTO, TipoRevisionEntity> {

    private static final TipoRevisionAssembler INSTANCE = new TipoRevisionAssembler();

    private TipoRevisionAssembler() {
        super();
    }

    public static final TipoRevisionAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public TipoRevisionDTO toDtoFromDomain(TipoRevisionDomain domain) {
        return TipoRevisionDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoRevisionDomain toDomainFromDto(TipoRevisionDTO dto) {
        return new TipoRevisionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public TipoRevisionEntity toEntityFromDomain(TipoRevisionDomain domain) {
        return new TipoRevisionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public TipoRevisionDomain toDomainFromEntity(TipoRevisionEntity entity) {
        return new TipoRevisionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<TipoRevisionDomain> toDomainListFromEntities(List<TipoRevisionEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
