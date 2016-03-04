package com.pigatron.shop.domain.repository;

import com.pigatron.shop.domain.entity.shipping.ShippingMethod;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMethodRepository extends MongoRepository<ShippingMethod, String> {
}
