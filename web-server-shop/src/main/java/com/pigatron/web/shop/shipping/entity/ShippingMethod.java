package com.pigatron.web.shop.shipping.entity;

import com.pigatron.web.shop.entity.Order;

import java.util.Optional;

public interface ShippingMethod {
	Optional<Float> getPriceFor(Order order);
}
