package com.pigatron.web.shop.catalogue.repository;

import com.pigatron.web.shop.catalogue.entity.Product;
import com.pigatron.web.shop.catalogue.entity.query.ProductQuery;

import java.util.List;

interface ProductRepositoryCustom {

    List<Product> find(ProductQuery query);

}
