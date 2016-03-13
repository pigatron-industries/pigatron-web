package com.pigatron.admin.domain.repository;


import com.pigatron.admin.domain.entity.catalogue.ProductImage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductImageRepository extends MongoRepository<ProductImage, String>  {
}
