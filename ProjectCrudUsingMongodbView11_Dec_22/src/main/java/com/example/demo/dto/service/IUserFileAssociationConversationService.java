package com.example.demo.dto.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IUserFileAssociationConversationService<TDto, TDomain> {

	public TDto toDto(TDomain domainObj);

    public List<TDto> toDtos(Collection<TDomain> domainList);

    public TDomain toDomainObject(TDto dto);

    public Set<TDomain> toDomainObjects(Collection<TDto> dtos);
}
