package com.pigatron.shop.catalogue.web.admin;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.service.ProductService;
import com.pigatron.server.web.rest.AbstractWriteRestController;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminProductController extends AbstractWriteRestController<Product> {

    private ProductService productService;

    @Autowired
    public AdminProductController(ProductService service) {
        super(service, "name");
        this.productService = service;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by sku")
    public Long countBySku(@RequestParam("sku") String sku) {
        return productService.countBySku(sku);
    }

}
