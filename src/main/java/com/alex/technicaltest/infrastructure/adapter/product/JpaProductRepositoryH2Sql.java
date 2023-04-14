package com.alex.technicaltest.infrastructure.adapter.product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.technicaltest.domain.model.Product;
import com.alex.technicaltest.domain.port.ProductRepository;
import com.alex.technicaltest.infrastructure.config.mapper.AssemblerService;
import com.alex.technicaltest.infrastructure.entity.ProductEntity;
import com.alex.technicaltest.infrastructure.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JpaProductRepositoryH2Sql implements ProductRepository{
    
    private final JpaProductRepository jpaProductRepo;
    private final AssemblerService assembler;
    
    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities = jpaProductRepo.findAll();
        return assembler.toDTOList(productEntities, Product.class);
    }

    @Override
    public Product getById(Long id) {
        ProductEntity productEntity = jpaProductRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("El producto con id: "+id+" no existe o no se encuentra."));
        return assembler.toDTO(productEntity, Product.class);
    }

    @Override
    @Transactional
    public Product create(Product product) {
        ProductEntity productEntity = assembler.toEntity(product, ProductEntity.class);
        return assembler.toDTO(jpaProductRepo.save(productEntity), Product.class);
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return create(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!jpaProductRepo.existsById(id)){
            log.warn("No se ha encontrado ningún producto con el id: "+id);
            throw new ResourceNotFoundException("El producto con id: "+id+" no se encuentra o no existe.");
        }
        jpaProductRepo.deleteById(id);
    }
    
}
