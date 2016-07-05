package com.pigatron.web.cms.content.repository;


import com.pigatron.web.cms.content.entity.Content;
import com.pigatron.web.cms.content.entity.ContentQuery;

import java.util.List;
import java.util.Optional;

public interface ContentRepositoryCustom {

    List<Content> find(ContentQuery query);

    Optional<Content> findPageByUrlKey(String urlKey);

    Optional<Content> findPublishedPageByUrlKey(String urlKey);
}
