package com.pigatron.web.cms.content.repository;


import com.pigatron.web.cms.content.entity.Content;

import java.util.Optional;

public interface ContentRepositoryCustom {
    Optional<Content> findPageByUrlKey(String urlKey);
    Optional<Content> findPublishedPageByUrlKey(String urlKey);
}
