package com.pigatron.shop.catalogue.web.admin;

import com.pigatron.shop.catalogue.service.ProductCategoryService;
import com.pigatron.shop.catalogue.web.customer.CustomerProductCategoryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminProductCategoryReadController extends CustomerProductCategoryController {

    @Autowired
    public AdminProductCategoryReadController(ProductCategoryService service) {
        super(service);
    }

}
