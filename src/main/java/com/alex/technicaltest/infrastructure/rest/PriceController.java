package com.alex.technicaltest.infrastructure.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.technicaltest.aplication.service.price.PriceService;
import com.alex.technicaltest.domain.model.Price;
import com.alex.technicaltest.infrastructure.util.Constants;

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
}
