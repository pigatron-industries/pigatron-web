package com.pigatron.web.core.entity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

public abstract class PageableQueryBuilder {

    private Sort.Direction sortDirection;
    private String sortField;
    private int page = 0;
    private int size = 100;

    public void setSortDir(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Query build() {
        Sort sort;
        if(sortDirection != null && sortField != null) {
            sort = Sort.by(sortDirection, sortField);
        } else {
            sort = Sort.unsorted();
        }

        Query query = new Query();
        query.with(PageRequest.of(page, size, sort));
        return query;
    }
}
