package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.EstadoAdministradorCategoriaDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.EstadoAdministradorCategoriaDTO;
import co.edu.uco.publiuco.entities.EstadoAdministradorCategoriaEntity;

public final class EstadoAdministradorCategoriaAssembler
        implements Assembler<EstadoAdministradorCategoriaDomain, EstadoAdministradorCategoriaDTO, EstadoAdministradorCategoriaEntity> {

    private static final EstadoAdministradorCategoriaAssembler INSTANCE = new EstadoAdministradorCategoriaAssembler();

    private EstadoAdministradorCategoriaAssembler() {
        super();
    }

    public static final EstadoAdministradorCategoriaAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoAdministradorCategoriaDTO toDtoFromDomain(EstadoAdministradorCategoriaDomain domain) {
        return EstadoAdministradorCategoriaDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoAdministradorCategoriaDomain toDomainFromDto(EstadoAdministradorCategoriaDTO dto) {
        return new EstadoAdministradorCategoriaDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public EstadoAdministradorCategoriaEntity toEntityFromDomain(EstadoAdministradorCategoriaDomain domain) {
        return new EstadoAdministradorCategoriaEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
    }

    @Override
    public EstadoAdministradorCategoriaDomain toDomainFromEntity(EstadoAdministradorCategoriaEntity entity) {
        return new EstadoAdministradorCategoriaDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
    }

    @Override
    public List<EstadoAdministradorCategoriaDomain> toDomainListFromEntities(List<EstadoAdministradorCategoriaEntity> entityList) {
        return entityList.stream()
                .map(entity -> toDomainFromEntity(entity)).toList();
    }
}

