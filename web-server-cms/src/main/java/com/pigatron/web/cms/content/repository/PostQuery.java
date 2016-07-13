package com.pigatron.web.cms.content.repository;

import com.pigatron.web.cms.content.entity.Post;
import com.pigatron.web.core.entity.PageableSortableQuery;
import org.springframework.data.mongodb.core.query.Query;

public class PostQuery extends PageableSortableQuery {

    @Override
    public Query createQuery() {
        Query query = super.createQuery();
        query.restrict(Post.class);
        return query;
    }

}
