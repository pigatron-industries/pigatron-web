package com.pigatron.cms.content.repository;

import com.pigatron.cms.content.entity.Page;
import com.pigatron.cms.content.entity.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class PageRepositoryImpl implements PageRepositoryCustom {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public List<Page> find(PageQuery productQuery) {
        Query query = new Query();
        return mongoOperations.find(query, Page.class);
    }

}
