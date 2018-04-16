package com.pigatron.web.cms.content.service;

import com.pigatron.web.cms.content.entity.Content;
import com.pigatron.web.cms.content.repository.ContentRepository;
import com.pigatron.web.core.service.AbstractRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContentService extends AbstractRepositoryService<Content> {

    @Autowired
    private ContentRepository contentRepository;

    public ContentService() {
        super(Content.class);
    }

    public Optional<Content> getPageByUrlKey(String urlKey) {
        return contentRepository.findPageByUrlKey(urlKey);
    }

    public Optional<Content> getPublishedPageByUrlKey(String urlKey) {
        return contentRepository.findPublishedPageByUrlKey(urlKey);
    }
}
