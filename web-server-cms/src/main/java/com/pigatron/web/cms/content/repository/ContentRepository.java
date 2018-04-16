package com.pigatron.web.cms.content.repository;

import com.pigatron.web.cms.content.entity.Content;
import com.pigatron.web.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends BaseRepository<Content>, ContentRepositoryCustom {
}
