package com.alex.technicaltest.infrastructure.adapter.brand;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.technicaltest.domain.model.Brand;
import com.alex.technicaltest.domain.port.BrandRepository;
import com.alex.technicaltest.infrastructure.config.mapper.AssemblerService;
import com.alex.technicaltest.infrastructure.entity.BrandEntity;
import com.alex.technicaltest.infrastructure.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class JpaBrandRepositoryH2Sql implements BrandRepository{
    
    private final JpaBrandRepository jpaBrandRepo;
    private final AssemblerService assembler;
    
    @Override
    public List<Brand> getAll() {
        List<BrandEntity> brandEntities = jpaBrandRepo.findAll();
        return assembler.toDTOList(brandEntities, Brand.class);
    }

    @Override
    public Brand getById(Long id) {
        BrandEntity brandEntity = jpaBrandRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("La marca con id: "+id+" no se encuentra o no existe."));
        return assembler.toDTO(brandEntity, Brand.class);
    }

    @Override
    @Transactional
    public Brand create(Brand brand) {
        BrandEntity brandEntity = assembler.toEntity(brand, BrandEntity.class);
        return assembler.toDTO(jpaBrandRepo.save(brandEntity), Brand.class);
    }

    @Override
    @Transactional
    public Brand update(Brand brand) {
       return create(brand);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!jpaBrandRepo.existsById(id)){
            throw new ResourceNotFoundException("La marca con id: "+id+" no se encuentra o no existe.");
        }
        jpaBrandRepo.deleteById(id);
    }
    
}
