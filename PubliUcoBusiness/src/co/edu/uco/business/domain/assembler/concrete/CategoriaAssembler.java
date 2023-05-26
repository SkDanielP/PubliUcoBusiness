package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.CategoriaDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.CategoriaDTO;
import co.edu.uco.publiuco.entities.CategoriaEntity;

public final class CategoriaAssembler implements Assembler<CategoriaDomain, CategoriaDTO, CategoriaEntity> {

    private static final CategoriaAssembler INSTANCE = new CategoriaAssembler();

    private CategoriaAssembler() {
        super();
    }

    public static CategoriaAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public CategoriaDTO toDtoFromDomain(CategoriaDomain domain) {
        return CategoriaDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion())
                .setEstado(EstadoCategoriaAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
    }

    @Override
    public CategoriaDomain toDomainFromDto(CategoriaDTO dto) {
        return new CategoriaDomain(
                dto.getIdentificador(),
                dto.getNombre(),
                dto.getDescripcion(),
                EstadoCategoriaAssembler.getInstance().toDomainFromDto(dto.getEstado())
        );
    }

    @Override
    public CategoriaEntity toEntityFromDomain(CategoriaDomain domain) {
        return new CategoriaEntity(
                domain.getIdentificador(),
                domain.getNombre(),
                domain.getDescripcion(),
                EstadoCategoriaAssembler.getInstance().toEntityFromDomain(domain.getEstado())
        );
    }

    @Override
    public CategoriaDomain toDomainFromEntity(CategoriaEntity entity) {
        return new CategoriaDomain(
                entity.getIdentificador(),
                entity.getNombre(),
                entity.getDescripcion(),
                EstadoCategoriaAssembler.getInstance().toDomainFromEntity(entity.getEstado())
        );
    }

    @Override
    public List<CategoriaDomain> toDomainListFromEntities(List<CategoriaEntity> entityList) {
        return entityList.stream()
                .map(this::toDomainFromEntity)
                .collect(Collectors.toList());
    }
}
