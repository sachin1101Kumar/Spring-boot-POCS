package com.ecommerce.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.dto.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
     public boolean deleteByName(String name);
     public boolean deleteBycategory(String CatgeoryName);
     
}
