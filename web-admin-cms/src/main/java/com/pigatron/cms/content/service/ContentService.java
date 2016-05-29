package com.pigatron.cms.content.service;

import com.pigatron.admin.service.AbstractRepositoryService;
import com.pigatron.cms.content.entity.Content;
import com.pigatron.cms.content.entity.ContentQuery;
import com.pigatron.cms.content.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService extends AbstractRepositoryService<Content> {

    private ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository repository) {
        super(repository);
        this.contentRepository = repository;
    }

    public List<Content> find(ContentQuery query) {
        return contentRepository.find(query);
    }

    public Content getByUrlKey(String urlKey) {
        return contentRepository.findByUrlKey(urlKey);
    }
}
