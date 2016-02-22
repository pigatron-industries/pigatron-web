package com.pigatron.shop.web.rest;

import com.pigatron.shop.domain.entity.catalogue.Product;
import com.pigatron.shop.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${url.admin}/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminProductController extends AbstractRestController<Product, String> {

    @Autowired
    public AdminProductController(ProductRepository productRepository) {
        super(productRepository, "name");
    }

}
