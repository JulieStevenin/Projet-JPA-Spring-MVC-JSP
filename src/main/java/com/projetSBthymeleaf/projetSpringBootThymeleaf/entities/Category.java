package com.projetSBthymeleaf.projetSpringBootThymeleaf.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products=new ArrayList<>();

    public Category() {
    }

    public Category(String nameCategory, List<Product> products) {
        this.nameCategory = nameCategory;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
