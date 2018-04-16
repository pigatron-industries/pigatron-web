package com.pigatron.web.cms.content.repository;


import com.pigatron.web.cms.content.entity.Content;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

public interface ContentRepositoryCustom {
    List<Content> query(Query query);
    Optional<Content> findPageByUrlKey(String urlKey);
    Optional<Content> findPublishedPageByUrlKey(String urlKey);
}
