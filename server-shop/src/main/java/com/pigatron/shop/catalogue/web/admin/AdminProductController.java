package com.pigatron.shop.catalogue.web.admin;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.entity.query.ProductQuery;
import com.pigatron.shop.catalogue.service.ProductService;
import com.pigatron.server.web.rest.AbstractWriteRestController;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminProductController extends AbstractWriteRestController<Product> {

    private ProductService productService;

    @Autowired
    public AdminProductController(ProductService service) {
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
    public List<Product> query(@RequestParam(value="option", required=false) Boolean option) {
        ProductQuery productQuery = new ProductQuery();
        productQuery.setOption(option);
        return productService.find(productQuery);
    }

}
