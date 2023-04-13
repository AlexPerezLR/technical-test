package com.alex.technicaltest.aplication.service.brand;

import java.util.List;

import com.alex.technicaltest.domain.model.Brand;

public interface BrandService {
    List<Brand> getBrands();
    Brand getBrandById(Long id);
    Brand createBrand(Brand brand);
    Brand updateBrand(Brand brand);
    void deleteBrandById(Long id);
}
