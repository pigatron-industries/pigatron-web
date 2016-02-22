package com.pigatron.shop.web.rest;

import com.pigatron.shop.domain.entity.catalogue.Product;
import com.pigatron.shop.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.shop}/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicProductController extends AbstractGetOnlyController<Product, String> {

    @Autowired
    public PublicProductController(ProductRepository productRepository) {
        super(productRepository, "name");
    }

}
