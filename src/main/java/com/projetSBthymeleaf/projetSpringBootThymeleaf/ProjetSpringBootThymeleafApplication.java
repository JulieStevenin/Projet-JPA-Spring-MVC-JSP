package com.projetSBthymeleaf.projetSpringBootThymeleaf;

import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Category;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Product;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.repositories.CategoryRepository;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ProjetSpringBootThymeleafApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetSpringBootThymeleafApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		categoryRepository.deleteAll();

		Category category1 = new Category();
		category1.setNameCategory("T-shirt");
		categoryRepository.save(category1);

		Category category2 = new Category();
		category2.setNameCategory("Robe");
		categoryRepository.save(category2);

		Product product1 = new Product();
		product1.setNameProduct("T-shirt col V noir");
		product1.setQuantityProduct(50);
		product1.setPrice(19.99f);
		product1.setSizeProduct("L");
		product1.setCategory(category1);
		productRepository.save(product1);

		Product product2 = new Product();
		product2.setNameProduct("Débardeur rouge");
		product2.setQuantityProduct(10);
		product2.setPrice(15.99f);
		product2.setSizeProduct("M");
		product2.setCategory(category1);
		productRepository.save(product2);

		Product product3 = new Product();
		product3.setNameProduct("Robe cocktail verte");
		product3.setQuantityProduct(5);
		product3.setPrice(59.99f);
		product3.setSizeProduct("M");
		product3.setCategory(category2);
		productRepository.save(product3);
	}
}


