package com.test.falabella.domain.model;

import com.test.falabella.exceptions.NotValidUrlException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class ProductEntity {

    private int id;
    private long sku;
    private String name;
    private String brand;
    private float size;
    private long price;
    private URL urlImage;
    private List <URL> urlOtherImages;

    public long getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public float getSize() {
        return size;
    }

    public long getPrice() {
        return price;
    }

    public URL getUrlImage() {
        return urlImage;
    }

    public List<URL> getUrlOtherImages() {
        return urlOtherImages;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setUrlImage(String urlImage) {
        URL url = validateUrl(urlImage);
        this.urlImage = url;
    }

    public void setUrlOtherImages(List<String> urlOtherImages) {
        this.urlOtherImages = urlOtherImages.stream().map(this::validateUrl).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private URL validateUrl(String urlImage){
        try {
            URL url = new URL(urlImage);
            url.toURI();
            return url;
        }catch (MalformedURLException | URISyntaxException e){
            throw new NotValidUrlException(urlImage);
        }
    }
}
