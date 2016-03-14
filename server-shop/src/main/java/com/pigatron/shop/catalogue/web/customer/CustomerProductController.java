package com.pigatron.shop.catalogue.web.customer;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.ProductService;
import com.pigatron.server.web.rest.AbstractReadRestController;
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
