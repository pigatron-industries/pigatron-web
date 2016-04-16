package com.pigatron.server.web.rest;


import com.pigatron.server.service.RepositoryService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class AbstractReadRestController<T> {

    protected RepositoryService<T> service;

    public AbstractReadRestController(RepositoryService<T> service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by id")
    public T get(@PathVariable String id) {
        return service.findOne(id);
    }

}
