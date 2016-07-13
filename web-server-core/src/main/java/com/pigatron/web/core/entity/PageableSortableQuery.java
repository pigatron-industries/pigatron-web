package com.pigatron.web.core.entity;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

abstract public class PageableSortableQuery {

    private Pageable pageable;
    private Sort sort;

    private Sort defaultSort;

    public PageableSortableQuery() {
    }

    public PageableSortableQuery(Sort defaultSort) {
        this.defaultSort = defaultSort;
    }

    public PageableSortableQuery(Sort.Direction defaultDirection, String defaultProperty) {
        this.defaultSort = createSort(defaultDirection, defaultProperty);
    }

    public void setSortablePageable(Integer page, Integer size, Sort.Direction direction, String sortProperty) {
        Sort sort = defaultSort;
        if(direction != null && sortProperty != null) {
            sort = createSort(direction, sortProperty);
        }

        if(page != null && size != null) {
            if(sort != null) {
                this.pageable = new PageRequest(page, size, sort);
            } else {
                this.pageable = new PageRequest(page, size);
            }
        } else {
            this.sort = sort;
        }
    }

    protected Sort createSort(Sort.Direction direction, String property) {
        Sort.Order order = new Sort.Order(direction, property);
        //order = order.ignoreCase(); Not implemented in MongoDB
        return new Sort(order);
    }

    public Query createQuery() {
        Query query = new Query();
        if(this.pageable != null) {
            query.with(pageable);
        } else if (this.sort != null) {
            query.with(sort);
        }
        return query;
    }
}
