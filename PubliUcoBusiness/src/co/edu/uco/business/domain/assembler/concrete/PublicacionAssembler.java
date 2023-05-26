package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.LectorDomain;
import co.edu.uco.business.domain.PublicacionDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.LectorDTO;
import co.edu.uco.publiuco.dto.PublicacionDTO;
import co.edu.uco.publiuco.entities.LectorEntity;
import co.edu.uco.publiuco.entities.PublicacionEntity;

public final class PublicacionAssembler implements Assembler<PublicacionDomain, PublicacionDTO, PublicacionEntity> {
	
	private static final PublicacionAssembler INSTANCE = new PublicacionAssembler();

    private PublicacionAssembler() {
        super();
    }

    public static PublicacionAssembler getInstance() {
        return INSTANCE;
    }
	
 @Override
    public PublicacionDTO toDtoFromDomain(PublicacionDomain domain) {
        return PublicacionDTO.create()
                .setIdentificador(domain.getIdentificador())
                .setCategoria(CategoriaAssembler.getInstance().toDtoFromDomain(domain.getCategoria()))
                .setTipoAcceso(TipoAccesoAssembler.getInstance().toDtoFromDomain(domain.getTipoAcceso()))
                .setEstadoPublicacion(EstadoPublicacionAssembler.getInstance().toDtoFromDomain(domain.getEstadoPublicacion()));
    }

    @Override
    public PublicacionDomain toDomainFromDto(PublicacionDTO dto) {
        return new PublicacionDomain(
                dto.getIdentificador(),
                CategoriaAssembler.getInstance().toDomainFromDto(dto.getCategoria()),
                TipoAccesoAssembler.getInstance().toDomainFromDto(dto.getTipoAcceso()),
                EstadoPublicacionAssembler.getInstance().toDomainFromDto(dto.getEstadoPublicacion())
        );
    }

    @Override
    public PublicacionEntity toEntityFromDomain(PublicacionDomain domain) {
        return new PublicacionEntity(
                domain.getIdentificador(),
                CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoria()),
                TipoAccesoAssembler.getInstance().toEntityFromDomain(domain.getTipoAcceso()),
                EstadoPublicacionAssembler.getInstance().toEntityFromDomain(domain.getEstadoPublicacion())
        );
    }

    @Override
    public PublicacionDomain toDomainFromEntity(PublicacionEntity entity) {
        return new PublicacionDomain(
                entity.getIdentificador(),
                CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoria()),
                TipoAccesoAssembler.getInstance().toDomainFromEntity(entity.getTipoAcceso()),
                EstadoPublicacionAssembler.getInstance().toDomainFromEntity(entity.getEstadoPublicacion())
        );
    }

    @Override
    public List<PublicacionDomain> toDomainListFromEntities(List<PublicacionEntity> entityList) {
        return entityList.stream()
                .map(this::toDomainFromEntity)
                .collect(Collectors.toList());
    }
}