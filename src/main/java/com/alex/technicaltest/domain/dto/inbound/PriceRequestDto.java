package com.alex.technicaltest.domain.dto.inbound;


import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceRequestDto {
    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;
}
