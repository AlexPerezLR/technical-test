package com.alex.technicaltest.infrastructure.adapter.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.technicaltest.infrastructure.entity.ProductEntity;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, Long>{

}
