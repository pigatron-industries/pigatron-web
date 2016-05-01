package com.pigatron.shop.shipping.entity;

/**
 * Represents a calculated shipping price option that can be selected by the customer.
 */
public class ShippingOption {

	private ShippingMethod shippingMethod;
	private float price;

	public ShippingOption() {
	}

	public ShippingOption(ShippingMethod shippingMethod, float price) {
		this.shippingMethod = shippingMethod;
		this.price = price;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
