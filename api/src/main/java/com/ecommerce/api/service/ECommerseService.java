package com.ecommerce.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.api.bean.ProductBean;
import com.ecommerce.api.dto.Product;
import com.ecommerce.api.dto.ProductCategory;

@Service
public interface ECommerseService {
	//fetch Apis
	public List<Product> getAllproducts();
	public Optional<Product> getProduct(Integer productId);
	public List<ProductCategory> getAllproductCategories();
	public Optional<ProductCategory> getProductCategory(Integer categoryId);
	//Create Apis
	public ProductBean saveProduct(ProductBean product);
	public ProductCategory saveProductCategory(ProductCategory categoryProductCategory);
	//update Apis
	public Product updateProduct(Product product);
	public ProductCategory updateProductCategory(ProductCategory productCategory);
	//delete apis
	public boolean deleteProduct(int productId);
	public boolean deleteProductByName(String name);
	public boolean deleteProductCategory(int productCategoryId);
	public boolean deleteProductCategortyByName(String categoryName);
}
