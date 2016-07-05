package com.pigatron.web.cms.image.repository;

import com.pigatron.web.cms.image.entity.Image;
import com.pigatron.web.cms.image.entity.ImageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


public class ImageRepositoryImpl implements ImageRepositoryCustom {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public List<Image> find(ImageQuery imageQuery) {
        Query query = new Query();
        return mongoOperations.find(query, Image.class);
    }
}
