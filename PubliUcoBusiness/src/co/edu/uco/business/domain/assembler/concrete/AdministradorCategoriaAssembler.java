package co.edu.uco.business.domain.assembler.concrete;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.business.domain.AdministradorCategoriaDomain;
import co.edu.uco.business.domain.assembler.Assembler;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;
import co.edu.uco.publiuco.entities.AdministradorCategoriaEntity;

public final class AdministradorCategoriaAssembler
        implements Assembler<AdministradorCategoriaDomain, AdministradorCategoriaDTO, AdministradorCategoriaEntity> {

	  private static final AdministradorCategoriaAssembler INSTANCE = new AdministradorCategoriaAssembler();

	    private AdministradorCategoriaAssembler() {
	        super();
	    }

	    public static final AdministradorCategoriaAssembler getInstance() {
	        return INSTANCE;
	    }

	    @Override
	    public AdministradorCategoriaDTO toDtoFromDomain(AdministradorCategoriaDomain domain) {
	        return AdministradorCategoriaDTO.create()
	                .setIdentificador(domain.getIdentificador())
	                .setNombre(domain.getNombre())
	                .setCorreo(domain.getCorreo())
	                .setTipoRelacionInstitucion(TipoRelacionInstitucionAssembler.getInstance().toDtoFromDomain(domain.getTipoRelacionInstitucion()))
	                .setEstado(EstadoAdministradorCategoriaAssembler.getInstance().toDtoFromDomain(domain.getEstado()));
	    }

	    @Override
	    public AdministradorCategoriaDomain toDomainFromDto(AdministradorCategoriaDTO dto) {
	        return new AdministradorCategoriaDomain(dto.getIdentificador(), dto.getCorreo(), dto.getNombre(),
	        			TipoRelacionInstitucionAssembler.getInstance().toDomainFromDto(dto.getTipoRelacionInstitucion()),
	        			EstadoAdministradorCategoriaAssembler.getInstance().toDomainFromDto(dto.getEstado())); 
	        		
	    }

	    @Override
	    public AdministradorCategoriaEntity toEntityFromDomain(AdministradorCategoriaDomain domain) {
	        return new AdministradorCategoriaEntity(domain.getIdentificador(), domain.getCorreo(), domain.getNombre(),
	        		TipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain.getTipoRelacionInstitucion()),
	        		EstadoAdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	        		
	    }

	    @Override
	    public AdministradorCategoriaDomain toDomainFromEntity(AdministradorCategoriaEntity entity) {
	        return new AdministradorCategoriaDomain(entity.getIdentificador(), entity.getCorreo(), entity.getNombre(),
	        		TipoRelacionInstitucionAssembler.getInstance().toDomainFromEntity(entity.getTipoRelacionInstitucion()),
	        		EstadoAdministradorCategoriaAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	    }

	    @Override
	    public List<AdministradorCategoriaDomain> toDomainListFromEntities(List<AdministradorCategoriaEntity> entityList) {
	        return entityList.stream()
	                .map(entity -> toDomainFromEntity(entity))
	                .collect(Collectors.toList());
	    }

}

