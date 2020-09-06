package com.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productservice.beans.Product;
import com.productservice.repository.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product entity=new Product();
		entity.setName("AC");
		
       productRepository.save(entity);
		
	}

}
