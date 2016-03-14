package com.pigatron.admin.domain.entity.shipping;

import com.pigatron.admin.domain.entity.sales.Order;

import java.util.Optional;

public interface ShippingMethod {
	Optional<Float> getPriceFor(Order order);
}
