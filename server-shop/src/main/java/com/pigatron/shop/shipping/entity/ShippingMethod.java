package com.pigatron.shop.shipping.entity;

import com.pigatron.shop.sales.entity.Order;

import java.util.Optional;

public interface ShippingMethod {
	Optional<Float> getPriceFor(Order order);
}
