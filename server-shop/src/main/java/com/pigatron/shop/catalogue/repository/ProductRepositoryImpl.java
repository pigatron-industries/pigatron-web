package com.pigatron.shop.catalogue.repository;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.entity.query.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public List<Product> find(ProductQuery productQuery) {
        Query query = new Query();
        if(productQuery.getOption() != null) {
            query.addCriteria(Criteria.where("option").is(productQuery.getOption()));
        }
        return mongoOperations.find(query, Product.class);
    }
}
