package com.pigatron.shop.catalogue.repository;


import com.pigatron.shop.catalogue.entity.ProductImage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends MongoRepository<ProductImage, String>  {
}
