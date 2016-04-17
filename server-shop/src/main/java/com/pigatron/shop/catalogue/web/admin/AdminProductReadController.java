package com.pigatron.shop.catalogue.web.admin;

import com.pigatron.shop.catalogue.service.ProductService;
import com.pigatron.shop.catalogue.web.customer.CustomerProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminProductReadController extends CustomerProductController {

    @Autowired
    public AdminProductReadController(ProductService service) {
        super(service);
    }

}
