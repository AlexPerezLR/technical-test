package com.alex.technicaltest.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Price {
    private Long id;
    
    @NotBlank(message = "El nombre no puede ser nulo o vacío")
    private String name;

    private Product product;
    private Brand brand;
    
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    private Integer priceList;
    private Integer priority;
    private BigDecimal price;
    private String currency;
}
