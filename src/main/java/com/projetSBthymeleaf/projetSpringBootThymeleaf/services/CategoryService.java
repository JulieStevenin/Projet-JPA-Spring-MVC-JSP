package com.projetSBthymeleaf.projetSpringBootThymeleaf.services;

import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Category;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        try {
            if (categoryRepository.existsById(category.getId())) {
                return categoryRepository.save(category);
            } else {
                System.out.println("Le produit avec l'ID " + category.getId() + " n'a pas été trouvé.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            System.out.println("La catégorie a été supprimée avec succès.");
        } else {
            System.out.println("La catégorie avec l'id " + id + " n'a pas été trouvée.");
        }
    }

    public void removeAll() {
        categoryRepository.deleteAll();
        System.out.println("Toutes les catégories ont été supprimées avec succès.");
    }
}