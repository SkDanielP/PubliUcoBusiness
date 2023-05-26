package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.CalificacionDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.CalificacionDTO;
import co.edu.uco.publiuco.entities.CalificacionEntity;

public final class CalificacionAssembler  implements Assembler<CalificacionDomain, CalificacionDTO, CalificacionEntity> {

	 private static final CalificacionAssembler INSTANCE = new CalificacionAssembler();

	    private CalificacionAssembler() {
	        super();
	    }

	    public static final CalificacionAssembler getInstance() {
	        return INSTANCE;
	    }

	    @Override
	    public CalificacionDTO toDtoFromDomain(CalificacionDomain domain) {
	        return CalificacionDTO.create()
	                .setIdentificador(domain.getIdentificador())
	                .setLector(LectorAssembler.getInstance().toDtoFromDomain(domain.getLector()))
	                .setPublicacion(PublicacionAssembler.getInstance().toDtoFromDomain(domain.getPublicacion()));
	    }

	    @Override
	    public CalificacionDomain toDomainFromDto(CalificacionDTO dto) {
	        return new CalificacionDomain(
	                dto.getIdentificador(),
	                LectorAssembler.getInstance().toDomainFromDto(dto.getLector()),
	                PublicacionAssembler.getInstance().toDomainFromDto(dto.getPublicacion())
	        );
	    }

	    @Override
	    public CalificacionEntity toEntityFromDomain(CalificacionDomain domain) {
	        return new CalificacionEntity(
	                domain.getIdentificador(),
	                LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()),
	                PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion())
	        );
	    }

	    @Override
	    public CalificacionDomain toDomainFromEntity(CalificacionEntity entity) {
	        return new CalificacionDomain(
	                entity.getIdentificador(),
	                LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()),
	                PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion())
	        );
	    }

	    @Override
	    public List<CalificacionDomain> toDomainListFromEntities(List<CalificacionEntity> entityList) {
	        return entityList.stream()
	                .map(entity -> toDomainFromEntity(entity))
	                .collect(Collectors.toList());
	    }

}