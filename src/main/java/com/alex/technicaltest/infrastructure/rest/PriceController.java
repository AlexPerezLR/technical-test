package com.alex.technicaltest.infrastructure.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.technicaltest.aplication.service.price.PriceService;
import com.alex.technicaltest.domain.dto.inbound.PriceRequestDto;
import com.alex.technicaltest.domain.model.Price;
import com.alex.technicaltest.infrastructure.util.Constants;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.PRICES_URL)
public class PriceController {
    private final PriceService priceService;

    @GetMapping("/")
    public ResponseEntity<List<Price>> getAll() {
        return ResponseEntity.ok(priceService.getPrices());
    }

    @GetMapping("")
    public ResponseEntity<Price> getPriceByParams(
        @PathParam("applicationDate") LocalDateTime applicationDate,
        @PathParam("productId") Long productId,
        @PathParam("brandId") Long brandId) {
            PriceRequestDto request = PriceRequestDto.builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .brandId(brandId).build();

            return ResponseEntity.ok(priceService.getPriceByParams(request));
    }
}
