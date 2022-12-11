package com.example.demo.dto.service;

import java.util.List;

public interface IContactConversationService<TDto,TDomain> {
	
	public TDomain toDomain(TDto tDto);
	public TDto toDto(TDomain tDomain);
	public List<TDto> toDtos(List<TDomain> tDomain);

}
