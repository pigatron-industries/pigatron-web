package com.pigatron.web.core.api;


import com.pigatron.web.core.service.RepositoryService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class AbstractWriteRestController<T> {

    protected RepositoryService<T> service;

    public AbstractWriteRestController(RepositoryService<T> service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by id")
    public T get(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create or update one")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "saved successfully"),
            @ApiResponse(code = 400, message = "Validation error")})
    public T save(@Valid @RequestBody T entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete all")
    public void delete() {
        service.deleteAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete one")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
