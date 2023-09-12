package com.projetSBthymeleaf.projetSpringBootThymeleaf.services;


import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Category;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Product;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findByNameProduct (String nameProduct) {
        return productRepository.findByNameProduct(nameProduct);
    }

    public Product updateProduct(Product product) {
        try {
            if (productRepository.existsById(product.getId())) {
                return productRepository.save(product);
            } else {
                System.out.println("Le produit avec l'ID " + product.getId() + " n'a pas été trouvé.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            System.out.println("Le produit a été supprimé avec succès.");
        } else {
            System.out.println("Le produit avec l'id " + id + " n'a pas été trouvé.");
        }
    }

    public void removeAll() {
        productRepository.deleteAll();
        System.out.println("Tous les produits ont été supprimés avec succès.");
    }
}
