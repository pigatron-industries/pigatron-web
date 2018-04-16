package com.pigatron.web.shop.catalogue.repository;

import com.pigatron.web.shop.catalogue.entity.Product;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

interface ProductRepositoryCustom {
    List<Product> query(Query query);
}
