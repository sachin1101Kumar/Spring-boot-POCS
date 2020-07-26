package com.ecommerce.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.bean.ProductBean;
import com.ecommerce.api.dto.Product;
import com.ecommerce.api.dto.ProductCategory;
import com.ecommerce.api.exceptions.ProductCategoryDoesNotExistException;
import com.ecommerce.api.exceptions.ProductDoesNotExistException;
import com.ecommerce.api.service.ECommerseService;

@RestController
@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE },produces = { MediaType.APPLICATION_JSON_VALUE })
public class ECommerseController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	ECommerseService ecommerseService;
	
	
	  @GetMapping(value ="/getproduct/{id}",produces ="application/json") 
	  public Optional<Product> getProduct(@PathVariable("id") Integer id){
		  log.info("Getting product detail from the database on bases of id");
		  Optional<Product> product = ecommerseService.getProduct(id);
	      if(product.equals(Optional.empty())) {
	    	  throw new ProductDoesNotExistException(id);
	      } 
	      else
		     return product; 
	  }
	  
	  @GetMapping(value = "/getproductCategory/{id}",produces ="application/json") 
	  public Optional<ProductCategory> getProductCategory(@PathVariable("id") Integer id){
		  log.info("Getting product category detail from the database on bases of id");
		  if(ecommerseService.getProductCategory(id)==null) {
	    	  throw new ProductCategoryDoesNotExistException("Product category does not exist....");
	      } 
	      else
		  return ecommerseService.getProductCategory(id); 
	  }
	  
	  @GetMapping(value="/products",produces ="application/json")
	  public List<Product> getAllProductsList(){
		  log.info("Getting product List from the database");
		  return ecommerseService.getAllproducts();
	  }
	  
	  @GetMapping(value="/productcategories",produces ="application/json")
	  public List<ProductCategory> getAllproductCatgories(){
		  log.info("Getting product category detail from the database.");
		  return ecommerseService.getAllproductCategories();
	  }
	  
	  @PostMapping(value="/product/save")
	  @ResponseBody
	  public ProductBean saveProduct(@RequestBody ProductBean product) {
		  log.info("Saving a product with data!!");
		  ProductBean savedProduct = null;
		 ecommerseService.saveProduct(product);
		  return savedProduct;
	  }
	 
	  @PostMapping(path="/productcategory/save")
	  @ResponseBody
	  public ProductCategory saveProductCategory(@RequestBody ProductCategory productCategory) {
		  log.info("Saving a product category with data!!"+productCategory.toString());
		  ProductCategory savedProductCategory=ecommerseService.saveProductCategory(productCategory);
		  return savedProductCategory;
	  }
	  
	  @PutMapping(path="/updateproduct")
	  @ResponseBody
	  public Product updateProduct(@RequestBody Product product) {
          log.info("Product is updated with the data !!!"+product);
		  Product savedProduct=ecommerseService.updateProduct(product);
		  return savedProduct;
	  }
	  
	  @PutMapping(path="/updateproductcategory")
	  @ResponseBody
	  public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory) {
          log.info("Product is updated with the data !!!"+productCategory);
		  ProductCategory savedProductCategory=ecommerseService.updateProductCategory(productCategory);
		  return savedProductCategory;
	  }
	  
	  @DeleteMapping(path="/productid/{id}")
	  public boolean deleteProduct(@PathVariable("id") int id) {
		  log.info("Product is deleted with the id !!!"+id);
		  return ecommerseService.deleteProduct(id);
	  }
	  
	  @DeleteMapping(path="/productname/{name}")
	  public boolean deleteProductByName(@PathVariable("name") String name) {
		  log.info("Product is deleted with the name !!!"+name);
		  return ecommerseService.deleteProductByName(name);
	  }
	  
	  @DeleteMapping(path="/categoryid/{id}")
	  public boolean deleteProductCategory(@PathVariable("id") int id) {
		  log.info("Product category is deleted with the id !!!"+id);
		  return ecommerseService.deleteProductCategory(id);
	  }
	  
	  @DeleteMapping(path="/categoryname/{name}")
	  public boolean deleteProductCategoryByName(@PathVariable("name") String name) {
		  log.info("Product category is deleted with the name !!!"+name);
		  return ecommerseService.deleteProductCategortyByName(name);
	  }

	  
	}
