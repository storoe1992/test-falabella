package com.test.falabella.domain.request;


import java.util.List;

public class ProductRequest {

    private int id;
    private long sku;
    private String name;
    private String brand;
    private float size;
    private long price;
    private String urlImage;
    private List<String> urlOtherImages;

    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<String> getUrlOtherImages() {
        return urlOtherImages;
    }

    public void setUrlOtherImages(List<String> urlOtherImages) {
        this.urlOtherImages = urlOtherImages;
    }
}
