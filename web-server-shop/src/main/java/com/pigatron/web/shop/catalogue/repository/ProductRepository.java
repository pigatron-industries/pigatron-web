package com.pigatron.web.shop.catalogue.repository;

import com.pigatron.web.core.repository.BaseRepository;
import com.pigatron.web.shop.catalogue.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product> {

    Product findBySku(String sku);

    Product findByUrlKey(String urlKey);

}
