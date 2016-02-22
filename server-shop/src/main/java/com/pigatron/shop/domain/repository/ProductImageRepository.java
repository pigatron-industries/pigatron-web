package com.pigatron.shop.domain.repository;


import com.pigatron.shop.domain.entity.catalogue.ProductImage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductImageRepository extends MongoRepository<ProductImage, String>  {
}
