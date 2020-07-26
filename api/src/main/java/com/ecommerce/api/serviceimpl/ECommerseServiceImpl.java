package com.ecommerce.api.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.api.bean.ProductBean;
import com.ecommerce.api.dto.Product;
import com.ecommerce.api.dto.ProductCategory;
import com.ecommerce.api.exceptions.ProductCreationException;
import com.ecommerce.api.exceptions.ProductDeletionFailed;
import com.ecommerce.api.respository.ProductCategoryRepository;
import com.ecommerce.api.respository.ProductRepository;
import com.ecommerce.api.service.ECommerseService;

public class ECommerseServiceImpl implements ECommerseService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	Product productEntity;
	
	@Override
	public List<Product> getAllproducts() {
		 List<Product> products=new ArrayList<Product>(); 
		 productRepository.findAll().forEach(product->products.add(product));
		 System.out.println(products);
		 return products;
	}

	@Override
	public Optional<Product> getProduct(Integer productId) {
		return productRepository.findById(productId);
	}

	@Override
	public List<ProductCategory> getAllproductCategories() {
		 List<ProductCategory> products=new ArrayList<ProductCategory>(); 
		 productCategoryRepository.findAll().forEach(product->products.add(product));
		 System.out.println(products);
		return products;
	}

	@Override
	public Optional<ProductCategory> getProductCategory(Integer categoryId) {
		return productCategoryRepository.findById(categoryId);
	}

	@Override
	public ProductBean saveProduct(ProductBean product) {
		ProductBean productResult = new ProductBean();
	 productEntity.setName(product.getName());
	 productEntity.setOwner(product.getOwner());
	 productEntity.setCategory(product.getCategory());
     Product prod=productRepository.saveAndFlush(productEntity);
	     if(null!=prod) {
	    	 System.out.println("New Product is created: "+prod); 
	    	 productResult.setId(prod.getId());
	    	 productResult.setName(prod.getName());
	    	 productResult.setCategory(prod.getCategory());
	    	 productResult.setOwner(prod.getOwner());
	    	 return productResult;
	     }
	     else {
	    	 throw new ProductCreationException("Product creation failed!!!");
	     }
		
	}

	@Override
	public ProductCategory saveProductCategory(ProductCategory categoryProductCategory) {
         ProductCategory category=productCategoryRepository.saveAndFlush(categoryProductCategory);
		   
         if(null!=category) {
			   System.out.println("Product Category has been created successfully!!");
			   return category;
		   }
		   else {
			   throw new ProductCreationException("Product category creation failed!!!!");
		   }
	}

	@Override
	public Product updateProduct(Product product) {
        Product updatedProduct= productRepository.saveAndFlush(product);
		if(null!=updatedProduct) {
			System.out.println("Product has been Updated successfully!!");
			return updatedProduct;
		}
		else {
			throw new ProductCreationException("Product updation failed!!!");
		}
	}

	@Override
	public ProductCategory updateProductCategory(ProductCategory productCategory) {
		ProductCategory updatedProductCategory= productCategoryRepository.saveAndFlush(productCategory);
		if(null!=updatedProductCategory) {
			System.out.println("Product has been Updated successfully!!");
			return updatedProductCategory;
		}
		else {
			throw new ProductCreationException("Product updation failed!!!");
		}
	}

	@Override
	public boolean deleteProduct(int productId) {
      boolean result;
		try {
		productRepository.deleteById(productId);
		result= true;
      }catch(Exception e) {
    	  result= false;
    	  throw new ProductDeletionFailed("Product Deletion Failed!!!");
      }
		return result;
	}

	@Override
	public boolean deleteProductByName(String name) {
		 boolean result;
			try {
			result=productRepository.deleteByName(name);
	      }catch(Exception e) {
	    	  result= false;
	    	  throw new ProductDeletionFailed("Product Deletion Failed!!!");
	      }
			return result;
	}

	@Override
	public boolean deleteProductCategory(int productCategoryId) {
		boolean result;
		try {
		productCategoryRepository.deleteById(productCategoryId);
		result= true;
      }catch(Exception e) {
    	  result= false;
    	  throw new ProductDeletionFailed("Product Category Deletion Failed!!!");
      }
		return result;
	}

	@Override
	public boolean deleteProductCategortyByName(String categoryName) {
		 boolean result;
			try {
			result=productCategoryRepository.deleteByName(categoryName);
	      }catch(Exception e) {
	    	  result= false;
	    	  throw new ProductDeletionFailed("Product Deletion Failed!!!");
	      }
			return result;
	}

	
}
