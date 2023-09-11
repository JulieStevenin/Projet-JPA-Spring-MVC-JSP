package com.projetSBthymeleaf.projetSpringBootThymeleaf.controllers;

import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Category;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Product;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*")
@Controller
@RequestMapping
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Je souhaite afficher la liste de toutes mes catégories:
    @GetMapping("/listCategories")
    public List findAllCategories(Model model) {
        List<Category> categories = categoryService.findAllCategories();
        return categories;
    }

    @GetMapping("/listidC/{id}")
    public String displayProduct(@PathVariable Long id, Model model) {
        try {
            Optional<Category> category = categoryService.findCategoryById(id);
            if (category.isPresent()) {
                model.addAttribute("category", category.get());
                return "listidC";
            } else {
                return "La catégorie que vous cherchez n'a pas été trouvée";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur";
        }
    }


}

