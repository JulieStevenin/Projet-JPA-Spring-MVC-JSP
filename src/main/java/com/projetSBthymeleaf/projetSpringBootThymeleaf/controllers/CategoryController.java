package com.projetSBthymeleaf.projetSpringBootThymeleaf.controllers;

import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Category;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Product;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.services.CategoryService;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
@Controller
public class CategoryController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String homepage(Model model) {
        return "index";
    }


    // Je souhaite afficher la liste de toutes mes catégories:
    @GetMapping("/categories")
    public String displayCategories(Model model) {
        model.addAttribute("listCategory", categoryService.findAllCategories());
        Category category = new Category();
        model.addAttribute("savedCategory", category);
        return "categories";
    }

    //Ajouter une catégorie :
    @GetMapping("/additionCategory")
    public String showCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "additionCategory";
    }

    @PostMapping("/additionCategory")
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryService.createCategory(category);
        return "redirect:/categories";
    }

    // Mettre à jour une catégorie :
    @PostMapping("/editCategory/{id}")
    public String updateCategory(@ModelAttribute("category") Category updatedCategory) {
        Category updated = categoryService.updateCategory(updatedCategory);
        if (updated != null) {
            return "redirect:/categories";
        } else {
            return "redirect:/categories";
        }
    }

}

