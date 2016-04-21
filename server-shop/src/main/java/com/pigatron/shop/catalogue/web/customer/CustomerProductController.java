package com.pigatron.shop.catalogue.web.customer;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.entity.query.ProductQuery;
import com.pigatron.shop.catalogue.service.ProductService;
import com.pigatron.server.web.rest.AbstractReadRestController;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${url.shop}/api/catalogue/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerProductController extends AbstractReadRestController<Product> {

    private ProductService productService;

    @Autowired
    public CustomerProductController(ProductService service) {
        super(service);
        this.productService = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"sku"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by SKU")
    public Product getBySku(@RequestParam("sku") String sku) {
        return productService.getBySku(sku);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"urlKey"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by URL Key")
    public Product getByUrlKey(@RequestParam("urlKey") String urlKey) {
        return productService.getByUrlKey(urlKey);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get with query")
    public List<Product> query(@RequestParam(value="hasOptions", required=false) Boolean hasOptions,
                               @RequestParam(value="isOption", required=false) Boolean isOption) {
        ProductQuery productQuery = new ProductQuery();
        productQuery.setHasOptions(hasOptions);
        productQuery.setIsOption(isOption);
        return productService.find(productQuery);
    }

}
