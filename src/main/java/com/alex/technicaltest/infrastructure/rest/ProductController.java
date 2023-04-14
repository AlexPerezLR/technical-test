package com.alex.technicaltest.infrastructure.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.technicaltest.aplication.service.product.ProductService;
import com.alex.technicaltest.domain.model.Product;
import com.alex.technicaltest.infrastructure.util.Constants;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.PRODUCTS_URL)
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getProducts());
    }
}
