package com.alex.technicaltest.domain.port;

import java.util.List;

import com.alex.technicaltest.domain.model.Price;

public interface PriceRepository {
    List<Price> getAll();
    Price getById(Integer id);
    Price create(Price price);
    Price update(Price price);
    void deleteById(Integer id);
}
