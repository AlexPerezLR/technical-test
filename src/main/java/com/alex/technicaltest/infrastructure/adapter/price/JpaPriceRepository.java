package com.alex.technicaltest.infrastructure.adapter.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.technicaltest.infrastructure.entity.PriceEntity;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
    
}
