package com.projetSBthymeleaf.projetSpringBootThymeleaf.controllers;

import org.springframework.ui.Model;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Product;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Je souhaite afficher la liste de tous mes produits :
    @GetMapping("/list")
    public List findAllProducts(Model model) {
        List<Product> products = productService.findAllProducts();
        return products;
    }

//    // Je souhaite afficher le produit selon son id :
//    @GetMapping("/listid/{id}")
//    public String findProductById(@PathVariable Long id, Model model) {
//        Optional<Product> product = productService.findProductById(id);
//        if (product.isPresent()) {
//            model.addAttribute("product", product.get());
//        } else {
//            model.addAttribute("product", null);
//        }
//        return "list";
//    }
//
//
//    // Je souhaite afficher le fromulaire qui me permettra d'ajouter un produit :
//
//
//    // Je valide la soumission du nouveau produit dans le formulaire
//    @PostMapping("/creationProduct")
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        Product savedProduct = productService.createProduct(product);
//        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
//    }
//}
}