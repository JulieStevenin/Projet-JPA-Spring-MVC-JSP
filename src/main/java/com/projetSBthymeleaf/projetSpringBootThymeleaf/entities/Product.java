package com.projetSBthymeleaf.projetSpringBootThymeleaf.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float price;
    private Integer quantityProduct;
    private String sizeProduct;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String nameProduct;

    public Product() {
    }

    public Product(Float price, Integer quantityProduct, String sizeProduct, Category category, String nameProduct) {
        this.price = price;
        this.quantityProduct = quantityProduct;
        this.sizeProduct = sizeProduct;
        this.category = category;
        this.nameProduct = nameProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getSizeProduct() {
        return sizeProduct;
    }

    public void setSizeProduct(String sizeProduct) {
        this.sizeProduct = sizeProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}