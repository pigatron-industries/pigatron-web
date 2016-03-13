package com.pigatron.admin.domain.repository;

import com.pigatron.admin.domain.entity.shipping.ShippingMethod;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMethodRepository extends MongoRepository<ShippingMethod, String> {
}
