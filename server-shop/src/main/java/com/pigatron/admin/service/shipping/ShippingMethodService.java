package com.pigatron.admin.service.shipping;

import com.pigatron.admin.domain.entity.sales.Order;
import com.pigatron.admin.domain.entity.shipping.ShippingMethod;
import com.pigatron.admin.domain.entity.shipping.ShippingOption;
import com.pigatron.admin.domain.repository.ShippingMethodRepository;
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
