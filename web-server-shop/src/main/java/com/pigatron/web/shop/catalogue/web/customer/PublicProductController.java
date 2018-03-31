package com.pigatron.web.shop.catalogue.web.customer;

import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.web.core.api.View;
import com.pigatron.web.shop.catalogue.entity.Product;
import com.pigatron.web.shop.catalogue.service.ProductService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "${url.public}/api/catalogue/product", produces = MediaType.APPLICATION_JSON_VALUE)
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
        return productService.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"sku"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by SKU")
    @JsonView(View.Public.class)
    public Product getBySku(@RequestParam("sku") String sku) {
        //TODO throw resource not found if not found
        return productService.getBySku(sku);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"urlKey"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by URL Key")
    @JsonView(View.Public.class)
    public Product getByUrlKey(@RequestParam("urlKey") String urlKey) {
        //TODO throw resource not found if not found
        return productService.getByUrlKey(urlKey);
    }

}
