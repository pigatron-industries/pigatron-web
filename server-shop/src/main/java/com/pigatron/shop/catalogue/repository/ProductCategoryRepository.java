package com.pigatron.shop.catalogue.repository;


import com.pigatron.shop.catalogue.entity.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {
}
