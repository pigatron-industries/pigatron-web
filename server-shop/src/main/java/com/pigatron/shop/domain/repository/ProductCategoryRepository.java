package com.pigatron.shop.domain.repository;


import com.pigatron.shop.domain.entity.catalogue.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {
}
