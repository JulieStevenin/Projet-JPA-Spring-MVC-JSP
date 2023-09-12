package com.projetSBthymeleaf.projetSpringBootThymeleaf.controllers;

import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Category;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.repositories.CategoryRepository;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.repositories.ProductRepository;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.services.CategoryService;
import org.springframework.ui.Model;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Product;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    // Je souhaite afficher la liste de tous mes produits :
    @GetMapping("/products")
    public String displayProducts(Model model) {
        model.addAttribute("listProduct", productService.findAllProducts());
        Product product = new Product();
        model.addAttribute("savedProduct", product);
        return "products";
    }

    //Afficher le formulaire d'ajout d'un produit :
    @GetMapping("/additionProduct")
    public String showProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "additionProduct";
    }

    // Ajouter un produit :
    @PostMapping("/additionProduct")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.createProduct(product);
        return "redirect:/products";
    }

    //Afficher le formulaire de mise à jour d'un produit :
    @GetMapping("/updationProduct") // Ajoutez {id} dans l'URL
    public String showUpdateFormProduct(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "updationProduct";
    }

    // Faire la màj :
    @PostMapping("/updationProduct")
    public String updateProduct(@PathVariable("id") Long id, @RequestParam("nameProduct") String nameProduct,
                                @RequestParam("sizeProduct") String sizeProduct, @RequestParam("price") Float price,
                                @RequestParam("quantityProduct") Integer quantityProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setNameProduct(nameProduct);
            product.setSizeProduct(sizeProduct);
            product.setQuantityProduct(quantityProduct);
            product.setPrice(price);
            productRepository.save(product);
            return "redirect:/products";
        } else {
            return "redirect:/updationProduct";
        }
    }
}