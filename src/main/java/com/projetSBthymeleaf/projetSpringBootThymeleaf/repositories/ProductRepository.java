package com.projetSBthymeleaf.projetSpringBootThymeleaf.repositories;

import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Category;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {

    Product findByNameProduct (String nameProduct);

}