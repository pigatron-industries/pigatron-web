package com.pigatron.web.shop.shipping;

import com.pigatron.web.shop.shipping.entity.ShippingMethod;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMethodRepository extends MongoRepository<ShippingMethod, String> {
}
