package com.alex.technicaltest.aplication.service.price;

import java.util.List;

import com.alex.technicaltest.domain.model.Price;

public interface PriceService {
    List<Price> getPrices();
    Price getPriceById(Integer id);
    Price createPrice(Price price);
    Price updatePrice(Price price);
    void deletePriceById(Integer id);
}
