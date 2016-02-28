package com.pigatron.shop.web.rest.admin;

import com.pigatron.shop.domain.entity.catalogue.ProductCategory;
import com.pigatron.shop.domain.repository.ProductCategoryRepository;
import com.pigatron.shop.web.rest.AbstractFullRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminProductCategoryController extends AbstractFullRestController<ProductCategory, String> {

    @Autowired
    public AdminProductCategoryController(ProductCategoryRepository productCategoryRepository) {
        super(productCategoryRepository, "name");
    }

}
