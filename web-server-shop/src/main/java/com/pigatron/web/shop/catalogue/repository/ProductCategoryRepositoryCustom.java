package com.pigatron.web.shop.catalogue.repository;

import com.pigatron.web.shop.catalogue.entity.ProductCategory;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

interface ProductCategoryRepositoryCustom {
    List<ProductCategory> query(Query query);
}
