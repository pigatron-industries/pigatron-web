package com.pigatron.shop.catalogue.web.admin;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.service.ProductService;
import com.pigatron.server.web.rest.AbstractWriteRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminProductWriteController extends AbstractWriteRestController<Product> {

    @Autowired
    public AdminProductWriteController(ProductService service) {
        super(service);
    }
}
