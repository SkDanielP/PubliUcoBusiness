package co.edu.uco.business.domain.assembler.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.business.domain.EstadoCategoriaDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoCategoriaDTO;
import co.edu.uco.publiuco.entities.EstadoCategoriaEntity;

public final class EstadoCategoriaAssembler
        implements Assembler<EstadoCategoriaDomain, EstadoCategoriaDTO, EstadoCategoriaEntity> {

    private static final EstadoCategoriaAssembler INSTANCE = new EstadoCategoriaAssembler();

    private EstadoCategoriaAssembler() {
        super();
    }

    public static final EstadoCategoriaAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoCategoriaDTO toDtoFromDomain(EstadoCategoriaDomain domain) {
        return EstadoCategoriaDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoCategoriaDomain toDomainFromDto(EstadoCategoriaDTO dto) {
        return new EstadoCategoriaDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoCategoriaEntity toEntityFromDomain(EstadoCategoriaDomain domain) {
        return new EstadoCategoriaEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoCategoriaDomain toDomainFromEntity(EstadoCategoriaEntity entity) {
        return new EstadoCategoriaDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoCategoriaDomain> toDomainListFromEntities(List<EstadoCategoriaEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

}