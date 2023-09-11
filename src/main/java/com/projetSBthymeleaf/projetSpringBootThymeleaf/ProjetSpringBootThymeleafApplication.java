package com.projetSBthymeleaf.projetSpringBootThymeleaf;

import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Category;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.entities.Product;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.repositories.CategoryRepository;
import com.projetSBthymeleaf.projetSpringBootThymeleaf.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "com.projetSBthymeleaf.projetSpringBootThymeleaf.entities")
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
		Category category1 = new Category();
		category1.setNameCategory("T-shirt");
		categoryRepository.save(category1);

		Product product1 = new Product();
		product1.setNameProduct("T-shirt col V noir");
		product1.setQuantityProduct(50);
		product1.setPrice(19.99f);
		product1.setCategory(category1);
		productRepository.save(product1);
	}
}


