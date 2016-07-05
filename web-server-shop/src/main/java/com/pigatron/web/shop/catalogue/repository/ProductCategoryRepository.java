package com.pigatron.web.shop.catalogue.repository;


import com.pigatron.web.shop.catalogue.entity.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {
}
