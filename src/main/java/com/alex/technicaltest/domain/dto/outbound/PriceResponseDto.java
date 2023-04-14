package com.alex.technicaltest.domain.dto.outbound;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PriceResponseDto {
    private Long productId;
    private Long brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    @JsonIgnore
    private Integer priority;
}
