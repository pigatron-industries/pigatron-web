package com.pigatron.shop.shipping.entity.methods;

import com.pigatron.shop.sales.entity.Order;
import com.pigatron.shop.shipping.entity.ShippingMethod;
import com.pigatron.shop.shipping.entity.ShippingMethodSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A Method of shipping, includes all data on weights sizes and prices for the method
 */
public class TableRateShippingMethod implements ShippingMethod {

	private String id;
	private String name; //e.g Royal Mail 1st Class

	private List<ShippingMethodSize> sizes = new ArrayList<>();


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ShippingMethodSize> getSizes() {
		return sizes;
	}

	public void setSizes(List<ShippingMethodSize> sizes) {
		this.sizes = sizes;
	}

	@Override
	public Optional<Float> getPriceFor(Order order) {
		//TODO
		return Optional.empty();
	}
}
