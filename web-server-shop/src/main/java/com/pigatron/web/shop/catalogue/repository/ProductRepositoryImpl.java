package com.pigatron.web.shop.catalogue.repository;

import com.pigatron.web.shop.catalogue.entity.Product;
import com.pigatron.web.shop.catalogue.entity.query.ProductQuery;
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
        if(productQuery.getIsOption() != null) {
            query.addCriteria(Criteria.where("isOption").is(productQuery.getIsOption()));
        }
        if(productQuery.getHasOptions() != null) {
            query.addCriteria(Criteria.where("options").exists(productQuery.getHasOptions()));
        }
        return mongoOperations.find(query, Product.class);
    }
}
