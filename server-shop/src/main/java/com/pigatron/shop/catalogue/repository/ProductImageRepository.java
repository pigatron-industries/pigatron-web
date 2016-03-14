package com.pigatron.shop.catalogue.repository;


import com.pigatron.shop.catalogue.entity.ProductImage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductImageRepository extends MongoRepository<ProductImage, String>  {
}
