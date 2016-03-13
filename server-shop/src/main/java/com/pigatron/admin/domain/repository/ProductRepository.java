package com.pigatron.admin.domain.repository;

import com.pigatron.admin.domain.entity.catalogue.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
