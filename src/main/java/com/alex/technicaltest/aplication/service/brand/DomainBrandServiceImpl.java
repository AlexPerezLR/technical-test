package com.alex.technicaltest.aplication.service.brand;

import java.util.List;

import com.alex.technicaltest.domain.model.Brand;
import com.alex.technicaltest.domain.port.BrandRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DomainBrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getBrands() {
        return brandRepository.getAll();
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.getById(id);
    }
 
    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.create(brand);
    }

    @Override
    public Brand updateBrand(Brand brand){
        return brandRepository.update(brand);
    }

    @Override
    public void deleteBrandById(Long id) {
        brandRepository.deleteById(id);
    }
    
}
