package com.alex.technicaltest.domain.dto.inbound;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceRequestDto {
    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;
}
