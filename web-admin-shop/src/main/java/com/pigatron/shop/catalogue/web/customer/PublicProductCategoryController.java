package com.pigatron.shop.catalogue.web.customer;

import com.pigatron.shop.catalogue.entity.ProductCategory;
import com.pigatron.shop.catalogue.service.ProductCategoryService;
import com.pigatron.admin.api.AbstractReadRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${url.shop}/api/catalogue/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicProductCategoryController extends AbstractReadRestController<ProductCategory> {

    @Autowired
    public PublicProductCategoryController(ProductCategoryService service) {
        super(service);
    }

}
