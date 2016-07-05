package com.pigatron.web.shop.catalogue.web.admin;

import com.pigatron.web.core.api.AbstractWriteRestController;
import com.pigatron.web.shop.catalogue.entity.ProductCategory;
import com.pigatron.web.shop.catalogue.service.ProductCategoryService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminProductCategoryController extends AbstractWriteRestController<ProductCategory> {

    private ProductCategoryService productCategoryService;

    @Autowired
    public AdminProductCategoryController(ProductCategoryService service) {
        super(service);
        this.productCategoryService = service;
    }

    @RequestMapping(value = "/{parentId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new category and add to given parent category")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "saved successfully"),
            @ApiResponse(code = 400, message = "Validation error")})
    public ProductCategory add(@PathVariable String parentId, @Valid @RequestBody ProductCategory newCategory) {
        return productCategoryService.addSubcategory(parentId, newCategory);
    }

}
