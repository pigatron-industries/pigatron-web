package com.pigatron.shop.domain.entity.shipping;

import java.util.ArrayList;
import java.util.List;

/**
 * The size of parcel for a shipping method
 */
public class ShippingMethodSize {

	private String name;
	private int length;
	private int width;
	private int depth;

	private List<ShippingMethodWeight> weights = new ArrayList<ShippingMethodWeight>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public List<ShippingMethodWeight> getWeights() {
		return weights;
	}

	public void setWeights(List<ShippingMethodWeight> weights) {
		this.weights = weights;
	}
}
