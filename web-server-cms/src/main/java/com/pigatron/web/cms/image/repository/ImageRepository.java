package com.pigatron.web.cms.image.repository;

import com.pigatron.web.cms.image.entity.Image;
import com.pigatron.web.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends BaseRepository<Image>, ImageRepositoryCustom {
}
