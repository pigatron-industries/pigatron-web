package com.pigatron.web.shop.catalogue.web.admin;

import com.pigatron.web.core.api.AbstractWriteRestController;
import com.pigatron.web.shop.catalogue.entity.Product;
import com.pigatron.web.shop.catalogue.entity.query.ProductQueryBuilder;
import com.pigatron.web.shop.catalogue.service.ProductService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminProductController extends AbstractWriteRestController<Product> {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"sku"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by SKU")
    public Product getBySku(@RequestParam("sku") String sku) {
        //TODO throw resource not found if not found
        return productService.getBySku(sku);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"urlKey"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by URL Key")
    public Product getByUrlKey(@RequestParam("urlKey") String urlKey) {
        //TODO throw resource not found if not found
        return productService.getByUrlKey(urlKey);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get with query")
    public List<Product> query(ProductQueryBuilder query) {
        return productService.query(query);
    }
}
