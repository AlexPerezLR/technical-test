package com.alex.technicaltest.domain.port;

import java.util.List;

import com.alex.technicaltest.domain.model.Product;

public interface ProductRepository {
    List<Product> getAll();
    Product getById(Long id);
    Product create(Product product);
    Product update(Product product);
    void deleteById(Long id);
}
