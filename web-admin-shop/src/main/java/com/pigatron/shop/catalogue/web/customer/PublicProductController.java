package com.pigatron.shop.catalogue.web.customer;

import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.admin.security.entity.View;
import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.service.ProductService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "${url.shop}/api/catalogue/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicProductController {

    private ProductService productService;

    @Autowired
    public PublicProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by id")
    @JsonView(View.Public.class)
    public Product get(@PathVariable String id) {
        return productService.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"sku"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by SKU")
    @JsonView(View.Public.class)
    public Product getBySku(@RequestParam("sku") String sku) {
        return productService.getBySku(sku);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"urlKey"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by URL Key")
    @JsonView(View.Public.class)
    public Product getByUrlKey(@RequestParam("urlKey") String urlKey) {
        return productService.getByUrlKey(urlKey);
    }

}
