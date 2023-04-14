package com.alex.technicaltest.infrastructure.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.technicaltest.aplication.service.brand.BrandService;
import com.alex.technicaltest.domain.model.Brand;
import com.alex.technicaltest.infrastructure.util.Constants;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.BRANDS_URL)
public class BrandController {
    private final BrandService brandService;

    @GetMapping("/")
    public ResponseEntity<List<Brand>> getAll(){
        return ResponseEntity.ok(brandService.getBrands());
    }
}
