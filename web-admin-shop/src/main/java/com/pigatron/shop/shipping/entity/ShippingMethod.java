package com.pigatron.shop.shipping.entity;

import com.pigatron.shop.order.entity.Order;

import java.util.Optional;

public interface ShippingMethod {
	Optional<Float> getPriceFor(Order order);
}
