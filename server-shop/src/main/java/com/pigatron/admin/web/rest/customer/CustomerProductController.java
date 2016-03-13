package com.pigatron.admin.web.rest.customer;

import com.pigatron.admin.domain.entity.catalogue.Product;
import com.pigatron.admin.service.catalogue.ProductService;
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
