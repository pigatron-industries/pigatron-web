package com.pigatron.admin.service.shipping;

import com.pigatron.admin.domain.entity.sales.Order;
import com.pigatron.admin.domain.entity.shipping.ShippingMethod;
import com.pigatron.admin.domain.repository.ShippingMethodRepository;
import com.pigatron.server.service.AbstractRepositoryService;
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
