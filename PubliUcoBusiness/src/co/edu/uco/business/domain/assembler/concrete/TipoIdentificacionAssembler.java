package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.TipoIdentificacionDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;
import co.edu.uco.publiuco.entities.TipoIdentificacionEntity;

public final class TipoIdentificacionAssembler
        implements Assembler<TipoIdentificacionDomain, TipoIdentificacionDTO, TipoIdentificacionEntity> {

    private static final TipoIdentificacionAssembler INSTANCE = new TipoIdentificacionAssembler();

    private TipoIdentificacionAssembler() {
        super();
    }

    public static final TipoIdentificacionAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public TipoIdentificacionDTO toDtoFromDomain(TipoIdentificacionDomain domain) {
        return TipoIdentificacionDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoIdentificacionDomain toDomainFromDto(TipoIdentificacionDTO dto) {
        return new TipoIdentificacionDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public TipoIdentificacionEntity toEntityFromDomain(TipoIdentificacionDomain domain) {
        return new TipoIdentificacionEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public TipoIdentificacionDomain toDomainFromEntity(TipoIdentificacionEntity entity) {
        return new TipoIdentificacionDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<TipoIdentificacionDomain> toDomainListFromEntities(List<TipoIdentificacionEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
