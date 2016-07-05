package com.pigatron.web.cms.image.repository;

import com.pigatron.web.cms.image.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends MongoRepository<Image, String>, ImageRepositoryCustom {
}
