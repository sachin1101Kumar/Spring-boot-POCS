package com.example.springbootmongodb.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongodb.model.Product;
import com.example.springbootmongodb.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/byname/{ownername}")
	public List<Product> getAllProductsByOwnerName(@PathParam("ownername") String ownername){
		return productRepository.findByOwnerString(ownername);
	}
	
	@GetMapping("/brandname/{brandName}")
	public List<Product> getAllProductsByBrandName(@PathParam("brandName") String brandName){
		return productRepository.findByBrand(brandName);
	}
	
}
