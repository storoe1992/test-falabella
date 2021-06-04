package com.test.falabella.domain.interfaces;

import com.test.falabella.domain.model.ProductEntity;

public interface ProductRepository {
    String addProduct(ProductEntity productEntity);

    ProductEntity getProductbyId(String productId);
}
