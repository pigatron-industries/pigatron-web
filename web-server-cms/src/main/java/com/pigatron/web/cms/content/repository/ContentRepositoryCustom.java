package com.pigatron.web.cms.content.repository;


import com.pigatron.web.cms.content.entity.Content;

import java.util.List;
import java.util.Optional;

public interface ContentRepositoryCustom {

    List<Content> find(ContentQuery query);

    List<Content> find(PostQuery postQuery);

    Optional<Content> findPageByUrlKey(String urlKey);

    Optional<Content> findPublishedPageByUrlKey(String urlKey);
}
