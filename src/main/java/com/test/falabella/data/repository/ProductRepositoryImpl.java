package com.test.falabella.data.repository;

import com.test.falabella.domain.interfaces.ProductRepository;
import com.test.falabella.domain.model.ProductEntity;
import com.test.falabella.exceptions.RepositoryEntityException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public String addProduct(ProductEntity productEntity) {
        try {
            return "0";
        }catch (Exception e){
            throw new RepositoryEntityException("Error while get entity");
        }
    }

    @Override
    public ProductEntity getProductbyId(String productId) {
        try {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setUrlOtherImages(Arrays.asList("https://unaurl.com", "https://segundaurl.com"));
            productEntity.setUrlImage("https://urlprincipal.com");
            productEntity.setSku(12312313);
            productEntity.setSize(123);
            productEntity.setName("Some name");
            productEntity.setId(0);
            productEntity.setPrice(234234324);
            productEntity.setBrand("Un brand");
            return productEntity;
        }catch (Exception e){
            throw new RepositoryEntityException("Error while adding Entity");
        }
    }
}
