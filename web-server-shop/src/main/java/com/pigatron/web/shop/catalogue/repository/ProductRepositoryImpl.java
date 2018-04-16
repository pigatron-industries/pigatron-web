package com.pigatron.web.shop.catalogue.repository;

import com.pigatron.web.shop.catalogue.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public List<Product> query(Query query) {
        return mongoOperations.find(query, Product.class);
    }
}
