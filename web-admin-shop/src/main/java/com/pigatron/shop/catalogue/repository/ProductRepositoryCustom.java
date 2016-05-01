package com.pigatron.shop.catalogue.repository;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.entity.query.ProductQuery;

import java.util.List;

interface ProductRepositoryCustom {

    List<Product> find(ProductQuery query);

}
