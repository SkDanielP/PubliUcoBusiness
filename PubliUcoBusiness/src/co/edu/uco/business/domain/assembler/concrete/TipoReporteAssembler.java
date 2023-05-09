package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.TipoReporteDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.TipoReporteDTO;
import co.edu.uco.publiuco.entities.TipoReporteEntity;

public final class TipoReporteAssembler
        implements Assembler<TipoReporteDomain, TipoReporteDTO, TipoReporteEntity> {

    private static final TipoReporteAssembler INSTANCE = new TipoReporteAssembler();

    private TipoReporteAssembler() {
        super();
    }

    public static final TipoReporteAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public TipoReporteDTO toDtoFromDomain(TipoReporteDomain domain) {
        return TipoReporteDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoReporteDomain toDomainFromDto(TipoReporteDTO dto) {
        return new TipoReporteDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public TipoReporteEntity toEntityFromDomain(TipoReporteDomain domain) {
        return new TipoReporteEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public TipoReporteDomain toDomainFromEntity(TipoReporteEntity entity) {
        return new TipoReporteDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<TipoReporteDomain> toDomainListFromEntities(List<TipoReporteEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}
