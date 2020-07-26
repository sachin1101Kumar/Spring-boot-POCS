package com.ecommerce.api;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecommerce.api.dto.Product;
import com.ecommerce.api.respository.ProductCategoryRepository;
import com.ecommerce.api.respository.ProductRepository;
import com.ecommerce.api.service.ECommerseService;
import com.ecommerce.api.serviceimpl.ECommerseServiceImpl;
@SpringBootApplication
public class EcommerseApiApplication /* implements CommandLineRunner */ {

	public static void main(String[] args) {
		SpringApplication.run(EcommerseApiApplication.class, args);
	}
	
	@Bean
	public ECommerseService getEcommerseService() {
		return new ECommerseServiceImpl();
	}
	
	@Bean
	public Product getProduct() {
		return new Product();
	}

	 @Autowired DataSource dataSource;
	  
	  @Autowired ProductRepository productRepository;
	  
	  @Autowired ProductCategoryRepository productCategoryRepository;
	/*
	 * @Autowired DataSource dataSource;
	 * 
	 * @Autowired ProductRepository productRepository;
	 * 
	 * @Autowired ProductCategoryRepository productCategoryRepository;
	 * 
	 * @Transactional
	 * 
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * System.out.println("DATASOURCE = " + dataSource);
	 * 
	 * System.out.println("\n1. Product : findAll()..."); for (Product customer :
	 * productRepository.findAll()) { System.out.println(customer); }
	 * 
	 * System.out.println("\n2.product Category : findAll()..."); for
	 * (ProductCategory customer : productCategoryRepository.findAll()) {
	 * System.out.println(customer.toString()); }
	 * 
	 * 
	 * System.out.println("Done!");
	 * 
	 * exit(0); }
	 */
}
