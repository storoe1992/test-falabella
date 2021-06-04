package com.test.falabella.domain.mappers;

import com.test.falabella.domain.interfaces.Mapper;
import com.test.falabella.domain.model.ProductEntity;
import com.test.falabella.domain.request.ProductRequest;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements Mapper<ProductRequest, ProductEntity> {

    @Override
    public ProductEntity map(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setBrand(productRequest.getBrand());
        productEntity.setName(productRequest.getName());
        productEntity.setPrice(productRequest.getPrice());
        productEntity.setSize(productRequest.getSize());
        productEntity.setSku(productRequest.getSku());
        productEntity.setUrlImage(productRequest.getUrlImage());
        productEntity.setUrlOtherImages(productRequest.getUrlOtherImages());
        productEntity.setId(productRequest.getId());
        return productEntity;
    }

    @Override
    public ProductRequest reverse(ProductEntity eo) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setBrand(eo.getBrand());
        productRequest.setId(eo.getId());
        productRequest.setName(eo.getName());
        productRequest.setSku(eo.getSku());
        productRequest.setPrice(eo.getPrice());
        productRequest.setSize(eo.getSize());
        productRequest.setUrlImage(eo.getUrlImage().toString());
        productRequest.setUrlOtherImages(eo.getUrlOtherImages().stream().map(URL::toString).collect(Collectors.toList()));
        return productRequest;
    }
}
