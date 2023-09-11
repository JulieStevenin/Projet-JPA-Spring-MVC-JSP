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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String nameProduct;

    public Product() {
    }

    public Product(String nameProduct, Float price, Integer quantityProduct, Category category) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantityProduct = quantityProduct;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}