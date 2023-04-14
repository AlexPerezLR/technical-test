package com.alex.technicaltest.infrastructure.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.alex.technicaltest.infrastructure.util.Constants;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = Constants.SCHEMA_NAME, name = "Price")
@Data
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    private BrandEntity brand;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Integer priceList;
    private Integer priority;
    private BigDecimal price;

    private String currency;
}
