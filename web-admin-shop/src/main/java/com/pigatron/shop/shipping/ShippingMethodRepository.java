package com.pigatron.shop.shipping;

import com.pigatron.shop.shipping.entity.ShippingMethod;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMethodRepository extends MongoRepository<ShippingMethod, String> {
}
