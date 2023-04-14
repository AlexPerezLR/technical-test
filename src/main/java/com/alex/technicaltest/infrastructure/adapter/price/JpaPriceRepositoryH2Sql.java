package com.alex.technicaltest.infrastructure.adapter.price;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.technicaltest.domain.dto.inbound.PriceRequestDto;
import com.alex.technicaltest.domain.dto.outbound.PriceResponseDto;
import com.alex.technicaltest.domain.model.Price;
import com.alex.technicaltest.domain.port.PriceRepository;
import com.alex.technicaltest.infrastructure.config.mapper.AssemblerService;
import com.alex.technicaltest.infrastructure.entity.PriceEntity;
import com.alex.technicaltest.infrastructure.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class JpaPriceRepositoryH2Sql implements PriceRepository{
    
    private final JpaPriceRepository jpaPriceRepo;
    private final AssemblerService assembler;

    @Override
    public List<Price> getAll() {
        List<PriceEntity> pricesEntity = jpaPriceRepo.findAll();
        return assembler.toDTOList(pricesEntity, Price.class);
    }

    @Override
    public Price getById(Long id) {
        PriceEntity priceEntity = jpaPriceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("El price con id: "+id+" no se encuentra o no existe."));
        return assembler.toDTO(priceEntity, Price.class);
    }

    @Override
    @Transactional
    public Price create(Price price) {
        PriceEntity priceEntity = assembler.toEntity(price, PriceEntity.class);
        return assembler.toDTO(jpaPriceRepo.save(priceEntity), Price.class);
    }

    @Override
    @Transactional
    public Price update(Price price){
        return create(price);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!jpaPriceRepo.existsById(id)){
            throw new ResourceNotFoundException("El proveedor con id: "+id+" no se encuentra o no existe.");
        }
        jpaPriceRepo.deleteById(id);
    }

    @Override
    public List<PriceResponseDto> getByRequestParams(PriceRequestDto request) {
        return jpaPriceRepo.findByParamsAndDateLight(request.getApplicationDate(), request.getProductId(), request.getBrandId());
    }
    
}
