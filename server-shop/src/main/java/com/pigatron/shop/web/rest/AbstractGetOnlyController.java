package com.pigatron.shop.web.rest;


import com.google.common.collect.Lists;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;
import java.util.List;

public class AbstractGetOnlyController<T, ID extends Serializable> {

    protected PagingAndSortingRepository<T, ID> repository;

    private String sortProperty;

    public AbstractGetOnlyController(PagingAndSortingRepository<T, ID> repository, String sortProperty) {
        this.repository = repository;
        this.sortProperty = sortProperty;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all")
    public List<T> get() {
        Iterable<T> all = repository.findAll(new Sort(Sort.Direction.ASC, sortProperty));
        return Lists.newArrayList(all);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by id")
    public T get(@PathVariable ID id) {
        return repository.findOne(id);
    }

}
