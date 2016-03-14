package com.pigatron.shop.shipping.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * The size of parcel for a shipping method
 */
public class ShippingMethodSize extends ShippingSize {

	private List<ShippingMethodWeight> weights = new ArrayList<>();

	public List<ShippingMethodWeight> getWeights() {
		return weights;
	}

	public void setWeights(List<ShippingMethodWeight> weights) {
		this.weights = weights;
	}
}
