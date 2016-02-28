package com.pigatron.shop.web.rest.customer;

import com.pigatron.shop.domain.entity.catalogue.ProductCategory;
import com.pigatron.shop.domain.repository.ProductCategoryRepository;
import com.pigatron.shop.web.rest.AbstractGetOnlyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.shop}/api/catalogue/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerCategoryController extends AbstractGetOnlyController<ProductCategory, String> {

    @Autowired
    public CustomerCategoryController(ProductCategoryRepository productCategoryRepository) {
        super(productCategoryRepository, "name");
    }

}
