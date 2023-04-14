package com.alex.technicaltest.aplication.service.price;

import java.util.List;

import com.alex.technicaltest.domain.dto.inbound.PriceRequestDto;
import com.alex.technicaltest.domain.dto.outbound.PriceResponseDto;
import com.alex.technicaltest.domain.model.Price;
import com.alex.technicaltest.domain.port.PriceRepository;
import com.alex.technicaltest.infrastructure.exception.ResourceNotFoundException;

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

    @Override
    public PriceResponseDto getPriceByParams(PriceRequestDto request) {
        //here goes the business logic.
        List<PriceResponseDto> prices = priceRepository.getByRequestParams(request);

        return prices.stream().reduce((acc, el) -> {
            return acc.getPriority()>el.getPriority() ? acc : el;
        }).orElseThrow(() -> new ResourceNotFoundException("No hay tarifas que coincidan con los parámetros proporcionados."));

    }
    
}
