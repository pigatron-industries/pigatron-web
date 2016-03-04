package com.pigatron.shop.web.rest.admin;

import com.pigatron.shop.domain.entity.shipping.ShippingMethod;
import com.pigatron.shop.service.shipping.ShippingMethodService;
import com.pigatron.shop.web.rest.AbstractWriteRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.admin}/api/shipping/method", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShippingMethodController extends AbstractWriteRestController<ShippingMethod> {

	@Autowired
	public ShippingMethodController(ShippingMethodService service) {
		super(service, "name");
	}

}
