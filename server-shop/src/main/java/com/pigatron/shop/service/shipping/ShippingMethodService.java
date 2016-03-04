package com.pigatron.shop.service.shipping;

import com.pigatron.shop.domain.entity.sales.Order;
import com.pigatron.shop.domain.entity.shipping.ShippingMethod;
import com.pigatron.shop.domain.repository.ShippingMethodRepository;
import com.pigatron.shop.service.AbstractRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingMethodService extends AbstractRepositoryService<ShippingMethod> {

	@Autowired
	public ShippingMethodService(ShippingMethodRepository repository) {
		super(repository);
	}

	public void getShippingOptionsForOrder(Order order) {
		//TODO
	}

}
