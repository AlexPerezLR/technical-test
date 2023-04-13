package com.alex.technicaltest.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alex.technicaltest.aplication.service.brand.BrandService;
import com.alex.technicaltest.aplication.service.brand.DomainBrandServiceImpl;
import com.alex.technicaltest.aplication.service.price.DomainPriceServiceImpl;
import com.alex.technicaltest.aplication.service.price.PriceService;
import com.alex.technicaltest.aplication.service.product.DomainProductServiceImpl;
import com.alex.technicaltest.aplication.service.product.ProductService;
import com.alex.technicaltest.domain.port.BrandRepository;
import com.alex.technicaltest.domain.port.PriceRepository;
import com.alex.technicaltest.domain.port.ProductRepository;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    //connecting infrastructure layer with application layer.
    @Bean
    public ProductService productBeanService(final ProductRepository productRepository){
        return new DomainProductServiceImpl(productRepository);
    }

    @Bean
    public PriceService priceBeanService(final PriceRepository priceRepository){
        return new DomainPriceServiceImpl(priceRepository);
    }

    @Bean
    public BrandService brandBeanService(final BrandRepository brandRepository){
        return new DomainBrandServiceImpl(brandRepository);
    }

    //swagger
    @Bean
    public OpenAPI customizeOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
          .addSecurityItem(new SecurityRequirement()
            .addList(securitySchemeName))
          .components(new Components()
            .addSecuritySchemes(securitySchemeName, new SecurityScheme()
              .name(securitySchemeName)
              .type(SecurityScheme.Type.HTTP)
              .scheme("bearer")
              .bearerFormat("JWT")));
    }
}
