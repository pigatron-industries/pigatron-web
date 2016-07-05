package com.pigatron.web.shop.catalogue.web.customer;

import com.pigatron.web.core.api.AbstractReadRestController;
import com.pigatron.web.shop.catalogue.entity.ProductCategory;
import com.pigatron.web.shop.catalogue.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.public}/api/catalogue/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicProductCategoryController extends AbstractReadRestController<ProductCategory> {

    @Autowired
    public PublicProductCategoryController(ProductCategoryService service) {
        super(service);
    }

}
