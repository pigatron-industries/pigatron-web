package com.pigatron.admin.domain.entity.shipping.methods;

import com.pigatron.admin.domain.entity.sales.Order;
import com.pigatron.admin.domain.entity.shipping.ShippingMethod;

import java.util.Optional;

public class FlatRateShippingMethod implements ShippingMethod {

	@Override
	public Optional<Float> getPriceFor(Order order) {
		//TODO
		return Optional.empty();
	}

}
