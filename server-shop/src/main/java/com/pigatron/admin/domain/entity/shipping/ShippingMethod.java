package com.pigatron.admin.domain.entity.shipping;

import java.util.ArrayList;
import java.util.List;

/**
 * A Method of shipping, includes all data on weights sizes and prices for the method
 */
public class ShippingMethod {

	private String id;
	private String name; //e.g Royal Mail 1st Class

	private List<ShippingMethodSize> sizes = new ArrayList<ShippingMethodSize>();


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
}
