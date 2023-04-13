package com.alex.technicaltest.infrastructure.config.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssemblerServiceImpl implements AssemblerService{
    private final ModelMapper modelMapper;

    @Override
    public <T, U> U toDTO(T entity, Class<U> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public <T, U> U toEntity(T dto, Class<U> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    @Override
    public <T, U> List<U> toEntityList(List<T> dto, Class<U> entityClass) {
        return dto.stream().map(el -> modelMapper.map(el, entityClass)).collect(Collectors.toList());
    }

    @Override
    public <T, U> List<U> toDTOList(List<T> entity, Class<U> dtoClass) {
        return entity.stream().map(el -> modelMapper.map(el, dtoClass)).collect(Collectors.toList());
    }
}
