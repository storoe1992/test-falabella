package com.test.falabella.domain.service;

import com.test.falabella.domain.interfaces.Mapper;
import com.test.falabella.domain.interfaces.ProductRepository;
import com.test.falabella.domain.interfaces.ProductService;
import com.test.falabella.domain.model.ProductEntity;
import com.test.falabella.domain.request.ProductRequest;
import com.test.falabella.domain.request.AddProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final Mapper<ProductRequest, ProductEntity> productMapper;
    private final ProductRepository productRepository;

    public ProductServiceImpl(Mapper<ProductRequest, ProductEntity> productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public AddProductResponse addProduct(ProductRequest request) {
        ProductEntity productEntity = productMapper.map(request);
        String id = productRepository.addProduct(productEntity);
        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setId(id);
        return addProductResponse;
    }

    @Override
    public ProductRequest getProduct(String productId) {
        ProductEntity product = productRepository.getProductbyId(productId);
        return productMapper.reverse(product);
    }
}
