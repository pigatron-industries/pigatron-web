package com.pigatron.shop.shipping.entity.methods;

import com.pigatron.shop.sales.entity.Order;
import com.pigatron.shop.shipping.entity.ShippingMethod;

import java.util.Optional;

public class FlatRateShippingMethod implements ShippingMethod {

	@Override
	public Optional<Float> getPriceFor(Order order) {
		//TODO
		return Optional.empty();
	}

}
