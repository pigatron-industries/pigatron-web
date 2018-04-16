package com.pigatron.web.shop.shipping;

import com.pigatron.web.core.service.AbstractRepositoryService;
import com.pigatron.web.shop.entity.Order;
import com.pigatron.web.shop.shipping.entity.ShippingMethod;
import com.pigatron.web.shop.shipping.entity.ShippingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShippingMethodService extends AbstractRepositoryService<ShippingMethod> {

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
