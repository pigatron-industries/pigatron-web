package com.pigatron.web.shop.catalogue.repository;

import com.pigatron.web.shop.catalogue.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {

    Product findBySku(String sku);

    Product findByUrlKey(String urlKey);

}
