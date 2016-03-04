package com.pigatron.shop.web.rest.customer;

import com.pigatron.shop.domain.entity.catalogue.Product;
import com.pigatron.shop.service.catalogue.ProductService;
import com.pigatron.shop.web.rest.AbstractReadRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.shop}/api/catalogue/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerProductController extends AbstractReadRestController<Product> {

    @Autowired
    public CustomerProductController(ProductService service) {
        super(service, "name");
    }

}
