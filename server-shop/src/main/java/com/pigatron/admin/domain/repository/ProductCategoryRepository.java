package com.pigatron.admin.domain.repository;


import com.pigatron.admin.domain.entity.catalogue.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {
}
