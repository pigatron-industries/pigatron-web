package com.pigatron.shop.shipping.entity;

import com.pigatron.shop.entity.Order;

import java.util.Optional;

public interface ShippingMethod {
	Optional<Float> getPriceFor(Order order);
}
