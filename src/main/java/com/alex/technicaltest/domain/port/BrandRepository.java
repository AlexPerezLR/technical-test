package com.alex.technicaltest.domain.port;

import java.util.List;

import com.alex.technicaltest.domain.model.Brand;

public interface BrandRepository {
    List<Brand> getAll();
    Brand getById(Long id);
    Brand create(Brand brand);
    Brand update(Brand brand);
    void deleteById(Long id);
}
