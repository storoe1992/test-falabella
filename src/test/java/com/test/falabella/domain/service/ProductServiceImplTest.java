package com.test.falabella.domain.service;

import com.test.falabella.domain.interfaces.Mapper;
import com.test.falabella.domain.interfaces.ProductRepository;
import com.test.falabella.domain.model.ProductEntity;
import com.test.falabella.domain.request.AddProductResponse;
import com.test.falabella.domain.request.ProductRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock Mapper<ProductRequest, ProductEntity> mapper;
    @Mock ProductRepository productRepository;
    @InjectMocks ProductServiceImpl productService;


    @Test
    void given_happy_path_add_entity_it_will_return_ok_entity() {
        //Arrange
        String someId = "some_id";
        ProductEntity productEntity = new ProductEntity();
        productEntity.setUrlOtherImages(Arrays.asList("https://unaurl.com", "https://segundaurl.com"));
        productEntity.setUrlImage("https://urlprincipal.com");
        productEntity.setSku(12312313);
        productEntity.setSize(123);
        productEntity.setName("Some name");
        productEntity.setId(0);
        productEntity.setPrice(234234324);
        productEntity.setBrand("Un brand");
        when(mapper.map(Mockito.any())).thenReturn(productEntity);
        when(productRepository.addProduct(productEntity)).thenReturn(someId);
        //Act
        AddProductResponse addProductResponse = productService.addProduct(any(ProductRequest.class));
        //Assert
        Assertions.assertEquals(addProductResponse.getId(),someId);
    }


    @Test
    void given_error_while_adding_from_repository_it_will_throw_exception() {
        //Arrange
        String someId = "some_id";
        ProductEntity productEntity = new ProductEntity();
        productEntity.setUrlOtherImages(Arrays.asList("https://unaurl.com", "https://segundaurl.com"));
        productEntity.setUrlImage("https://urlprincipal.com");
        productEntity.setSku(12312313);
        productEntity.setSize(123);
        productEntity.setName("Some name");
        productEntity.setId(0);
        productEntity.setPrice(234234324);
        productEntity.setBrand("Un brand");
        when(mapper.map(Mockito.any())).thenReturn(productEntity);
        RuntimeException someException = new RuntimeException();
        when(productRepository.addProduct(productEntity)).thenThrow(someException);
        //Act && Assert
        Assertions.assertThrows(RuntimeException.class ,() -> productService.addProduct(any(ProductRequest.class)));
    }
}