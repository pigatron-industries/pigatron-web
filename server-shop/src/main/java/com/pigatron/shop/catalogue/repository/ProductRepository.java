package com.pigatron.shop.catalogue.repository;

import com.pigatron.shop.catalogue.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findBySku(String sku);

    Product findByUrlKey(String urlKey);

}
