package com.pigatron.shop.catalogue.web.customer;

import com.pigatron.shop.catalogue.entity.ProductCategory;
import com.pigatron.shop.catalogue.service.ProductCategoryService;
import com.pigatron.server.web.rest.AbstractReadRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.shop}/api/catalogue/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerProductCategoryController extends AbstractReadRestController<ProductCategory> {

    @Autowired
    public CustomerProductCategoryController(ProductCategoryService service) {
        super(service);
    }

}
