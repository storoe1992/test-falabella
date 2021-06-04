package com.test.falabella.controller;

import com.test.falabella.domain.interfaces.ProductService;
import com.test.falabella.domain.request.ProductRequest;
import com.test.falabella.domain.request.AddProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity <AddProductResponse> addProduct(@RequestBody ProductRequest request){
        AddProductResponse addProductResponse = productService.addProduct(request);
        return ResponseEntity.ok(addProductResponse);
    }

    @RequestMapping("/{productId}")
    public ResponseEntity<ProductRequest> getProduct(@PathVariable("productId")String productId){
        ProductRequest productRequest = productService.getProduct(productId);
        return ResponseEntity.ok(productRequest);
    }
}
