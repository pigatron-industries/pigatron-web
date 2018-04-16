package com.pigatron.web.cms.image.repository;


import com.pigatron.web.cms.image.entity.Image;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface ImageRepositoryCustom {
    List<Image> query(Query query);
}
