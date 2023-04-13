package com.alex.technicaltest.aplication.service.product;

import java.util.List;

import com.alex.technicaltest.domain.model.Product;
import com.alex.technicaltest.domain.port.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DomainProductServiceImpl implements ProductService{
    
    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.getAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.create(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.update(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
    
}
