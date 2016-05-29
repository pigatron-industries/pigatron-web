package com.pigatron.cms.content.repository;

import com.pigatron.cms.content.entity.Content;
import com.pigatron.cms.content.entity.ContentQuery;

import java.util.List;

public interface ContentRepositoryCustom {

    List<Content> find(ContentQuery query);

    Content findByUrlKey(String urlKey);
}
