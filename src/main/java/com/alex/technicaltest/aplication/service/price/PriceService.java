package com.alex.technicaltest.aplication.service.price;

import java.util.List;

import com.alex.technicaltest.domain.dto.inbound.PriceRequestDto;
import com.alex.technicaltest.domain.dto.outbound.PriceResponseDto;
import com.alex.technicaltest.domain.model.Price;

public interface PriceService {
    List<Price> getPrices();
    Price getPriceById(Long id);
    Price createPrice(Price price);
    Price updatePrice(Price price);
    void deletePriceById(Long id);
    PriceResponseDto getPriceByParams(PriceRequestDto request);
}
