package com.alex.technicaltest.infrastructure.adapter.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.technicaltest.infrastructure.entity.BrandEntity;

@Repository
public interface JpaBrandRepository extends JpaRepository<BrandEntity, Long>{
    
}
