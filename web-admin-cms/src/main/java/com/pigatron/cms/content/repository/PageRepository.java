package com.pigatron.cms.content.repository;

import com.pigatron.cms.content.entity.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends MongoRepository<Page, String>, PageRepositoryCustom {
}
