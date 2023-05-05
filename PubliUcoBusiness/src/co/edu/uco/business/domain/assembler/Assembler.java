package co.edu.uco.business.domain.assembler;

import java.util.List;

public interface Assembler<D, T, E> {
	
	T toDtoFromDomain(D domain);
	D toDomainFromDto(T dto);
	E toEntityFromDomain(D domain);
	D toDomainFromEntity(E entity);
	List<D>toDomainListFromEntities(List<E> entityList);
}
