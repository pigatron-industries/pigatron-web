package com.pigatron.shop.domain.repository;

import com.pigatron.shop.domain.entity.catalogue.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
