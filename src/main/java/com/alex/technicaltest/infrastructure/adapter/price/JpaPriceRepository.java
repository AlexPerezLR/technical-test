package com.alex.technicaltest.infrastructure.adapter.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.technicaltest.infrastructure.entity.BrandEntity;

@Repository
public interface JpaPriceRepository extends JpaRepository<BrandEntity, Integer> {
    // boolean existsById(Integer id);
}
