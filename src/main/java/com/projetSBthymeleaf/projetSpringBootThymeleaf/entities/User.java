package com.projetSBthymeleaf.projetSpringBootThymeleaf.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_product",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productsOrdered;

    public User() {
    }

    public User(String fname, String lname, String username, String password, List<Product> productsOrdered) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.productsOrdered = productsOrdered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getProductsOrdered() {
        return productsOrdered;
    }

    public void setProductsOrdered(List<Product> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }
}
