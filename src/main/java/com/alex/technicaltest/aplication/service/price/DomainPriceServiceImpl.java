package com.alex.technicaltest.aplication.service.price;

import java.util.List;

import com.alex.technicaltest.domain.model.Price;
import com.alex.technicaltest.domain.port.PriceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DomainPriceServiceImpl implements PriceService {
    
    private final PriceRepository priceRepository;
    
    @Override
    public List<Price> getPrices() {
        return priceRepository.getAll();
    }

    @Override
    public Price getPriceById(Long id) {
        return priceRepository.getById(id);
    }

    @Override
    public Price createPrice(Price price) {
       return priceRepository.create(price);
    }

    @Override
    public Price updatePrice(Price price) {
        return priceRepository.update(price);
    }

    @Override
    public void deletePriceById(Long id) {
        priceRepository.deleteById(id);
    }
    
}
