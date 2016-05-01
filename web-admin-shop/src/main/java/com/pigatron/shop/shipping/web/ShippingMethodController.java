package com.pigatron.shop.shipping.web;

import com.pigatron.shop.shipping.entity.ShippingMethod;
import com.pigatron.shop.shipping.ShippingMethodService;
import com.pigatron.admin.api.AbstractWriteRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.admin}/api/shipping/method", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShippingMethodController extends AbstractWriteRestController<ShippingMethod> {

	@Autowired
	public ShippingMethodController(ShippingMethodService service) {
		super(service);
	}

}
