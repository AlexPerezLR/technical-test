package com.alex.technicaltest.aplication.service.product;

import java.util.List;

import com.alex.technicaltest.domain.model.Product;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProductById(Long id);
}
