package com.example.springbootmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootmongodb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    public List<Product> findByOwnerString(String ownerString);
    public List<Product>  findByBrand(String brandName);
}
