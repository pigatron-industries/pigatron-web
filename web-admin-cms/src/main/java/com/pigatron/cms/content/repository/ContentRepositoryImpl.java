package com.pigatron.cms.content.repository;

import com.pigatron.cms.content.entity.Content;
import com.pigatron.cms.content.entity.ContentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class ContentRepositoryImpl implements ContentRepositoryCustom {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public List<Content> find(ContentQuery productQuery) {
        Query query = new Query();
        return mongoOperations.find(query, Content.class);
    }

    @Override
    public Content findByUrlKey(String urlKey) {
        Query query = new Query();
        query.addCriteria(Criteria.where("urlKey").is(urlKey));
        List<Content> contents = mongoOperations.find(query, Content.class);
        return contents.size() > 0 ? contents.get(0) : null;
    }

}
