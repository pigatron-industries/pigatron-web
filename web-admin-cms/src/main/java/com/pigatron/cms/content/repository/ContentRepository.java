package com.pigatron.cms.content.repository;

import com.pigatron.cms.content.entity.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends MongoRepository<Content, String>, ContentRepositoryCustom {

}
