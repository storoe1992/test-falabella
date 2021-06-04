package com.test.falabella.domain.interfaces;

import com.test.falabella.domain.request.ProductRequest;
import com.test.falabella.domain.request.AddProductResponse;

public interface ProductService {
    AddProductResponse addProduct(ProductRequest request);

    ProductRequest getProduct(String productId);
}
