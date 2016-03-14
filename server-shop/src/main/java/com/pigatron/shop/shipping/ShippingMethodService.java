package com.pigatron.shop.shipping;

import com.pigatron.shop.sales.entity.Order;
import com.pigatron.shop.shipping.entity.ShippingMethod;
import com.pigatron.shop.shipping.entity.ShippingOption;
import com.pigatron.server.service.AbstractRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShippingMethodService extends AbstractRepositoryService<ShippingMethod> {

	@Autowired
	public ShippingMethodService(ShippingMethodRepository repository) {
		super(repository);
	}

	public List<ShippingOption> getShippingOptionsForOrder(Order order) {
		List<ShippingMethod> shippingMethods = repository.findAll();
		List<ShippingOption> shippingOptions = new ArrayList<>();

		for(ShippingMethod shippingMethod : shippingMethods) {
			Optional<Float> price = shippingMethod.getPriceFor(order);
			if(price.isPresent()) {
				shippingOptions.add(new ShippingOption(shippingMethod, price.get()));
			}
		}

		return shippingOptions;
	}

}
