package com.pigatron.web.shop.shipping.entity.methods;

import com.pigatron.web.shop.entity.Order;
import com.pigatron.web.shop.shipping.entity.ShippingMethod;

import java.util.Optional;

public class FlatRateShippingMethod implements ShippingMethod {

	@Override
	public Optional<Float> getPriceFor(Order order) {
		//TODO
		return Optional.empty();
	}

}
