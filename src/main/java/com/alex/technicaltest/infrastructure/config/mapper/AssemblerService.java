package com.alex.technicaltest.infrastructure.config.mapper;

import java.util.List;

public interface AssemblerService {
    public <T, U> U toDTO(T entity, Class<U> dtoClass);
    public <T, U> U toEntity(T dto, Class<U> entityClass);
    public <T, U> List<U> toEntityList(List<T> dto, Class<U> entityClass);
    public <T, U> List<U> toDTOList(List<T> entity, Class<U> dtoClass);
}
