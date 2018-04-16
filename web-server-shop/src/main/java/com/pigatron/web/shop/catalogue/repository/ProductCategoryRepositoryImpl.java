package com.pigatron.web.shop.catalogue.repository;

import com.pigatron.web.shop.catalogue.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCategoryRepositoryImpl implements ProductCategoryRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<ProductCategory> query(Query query) {
        return mongoOperations.find(query, ProductCategory.class);
    }
}
