package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.TipoAccesoDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.TipoAccesoDTO;
import co.edu.uco.publiuco.entities.TipoAccesoEntity;

public final class TipoAccesoAssembler
        implements Assembler<TipoAccesoDomain, TipoAccesoDTO, TipoAccesoEntity> {

    private static final TipoAccesoAssembler INSTANCE = new TipoAccesoAssembler();

    private TipoAccesoAssembler() {
        super();
    }

    public static final TipoAccesoAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public TipoAccesoDTO toDtoFromDomain(TipoAccesoDomain domain) {
        return TipoAccesoDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoAccesoDomain toDomainFromDto(TipoAccesoDTO dto) {
        return new TipoAccesoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public TipoAccesoEntity toEntityFromDomain(TipoAccesoDomain domain) {
        return new TipoAccesoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public TipoAccesoDomain toDomainFromEntity(TipoAccesoEntity entity) {
        return new TipoAccesoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<TipoAccesoDomain> toDomainListFromEntities(List<TipoAccesoEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}