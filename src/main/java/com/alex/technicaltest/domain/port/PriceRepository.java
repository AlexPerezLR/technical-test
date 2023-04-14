package com.alex.technicaltest.domain.port;

import java.util.List;

import com.alex.technicaltest.domain.dto.inbound.PriceRequestDto;
import com.alex.technicaltest.domain.dto.outbound.PriceResponseDto;
import com.alex.technicaltest.domain.model.Price;

public interface PriceRepository {
    List<Price> getAll();
    Price getById(Long id);
    Price create(Price price);
    Price update(Price price);
    void deleteById(Long id);
    List<PriceResponseDto> getByRequestParams(PriceRequestDto request);
}
