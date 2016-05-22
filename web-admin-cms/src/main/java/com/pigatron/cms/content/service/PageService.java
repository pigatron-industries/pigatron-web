package com.pigatron.cms.content.service;

import com.pigatron.admin.service.AbstractRepositoryService;
import com.pigatron.cms.content.entity.Page;
import com.pigatron.cms.content.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService extends AbstractRepositoryService<Page> {

    private PageRepository pageRepository;

    @Autowired
    public PageService(PageRepository repository) {
        super(repository);
        this.pageRepository = repository;
    }

}
