package com.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.beans.Product;
import com.productservice.configurations.ProductConfigurations;
import com.productservice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductConfigurations productConf;
	
	@GetMapping("/all-products")
	public List<Product> getAllProducts(){
		return productService.fetchAllProducts();
	}
	
	@GetMapping("/product-price")
	public Long getProductPrice() {
	 return productConf.getPrice();
	}
}
