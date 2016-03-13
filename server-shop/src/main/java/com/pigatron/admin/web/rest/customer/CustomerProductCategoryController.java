package com.pigatron.admin.web.rest.customer;

import com.pigatron.admin.domain.entity.catalogue.ProductCategory;
import com.pigatron.admin.service.catalogue.ProductCategoryService;
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
        super(service, "name");
    }

}
