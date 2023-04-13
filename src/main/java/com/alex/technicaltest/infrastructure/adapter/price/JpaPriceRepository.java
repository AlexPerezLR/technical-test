package com.alex.technicaltest.infrastructure.adapter.price;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alex.technicaltest.domain.dto.outbound.PriceResponseDto;
import com.alex.technicaltest.infrastructure.entity.PriceEntity;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query("SELECT e FROM PriceEntity e WHERE e.product.id = :productId "
    + "AND e.brand.id = :brandId AND e.startDate <= :applicationDate AND e.endDate >= :applicationDate")
    List<PriceEntity> findByParamsAndDate(@Param("applicationDate") LocalDateTime applicationDate, 
                           @Param("productId") Long productId, 
                           @Param("brandId") Long brandId);
    @Query("SELECT NEW com.alex.technicaltest.domain.dto.outbound.PriceResponseDto(e.product.id, e.brand.id, e.priceList, e.startDate, e.endDate, e.price) FROM PriceEntity e WHERE e.product.id = :productId "
    + "AND e.brand.id = :brandId AND e.startDate <= :applicationDate AND e.endDate >= :applicationDate")
    List<PriceResponseDto> findByParamsAndDateLight(@Param("applicationDate") LocalDateTime applicationDate, 
                           @Param("productId") Long productId, 
                           @Param("brandId") Long brandId);
}
