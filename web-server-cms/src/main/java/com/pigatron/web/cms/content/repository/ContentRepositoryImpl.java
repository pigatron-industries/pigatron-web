package com.pigatron.web.cms.content.repository;


import com.pigatron.web.cms.content.entity.Content;
import com.pigatron.web.cms.content.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

public class ContentRepositoryImpl implements ContentRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Content> query(Query query) {
        return mongoOperations.find(query, Content.class);
    }

    @Override
    public Optional<Content> findPageByUrlKey(String urlKey) {
        Query query = new Query();
        query.restrict(Page.class);
        query.addCriteria(Criteria.where("urlKey").is(urlKey));
        return mongoOperations.find(query, Content.class).stream().findFirst();
    }

    @Override
    public Optional<Content> findPublishedPageByUrlKey(String urlKey) {
        Query query = new Query();
        query.restrict(Page.class);
        query.addCriteria(Criteria.where("urlKey").is(urlKey));
        query.addCriteria(Criteria.where("enabled").is(true));
        return mongoOperations.find(query, Content.class).stream().findFirst();
    }
}
