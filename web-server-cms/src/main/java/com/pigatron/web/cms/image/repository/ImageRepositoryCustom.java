package com.pigatron.web.cms.image.repository;


import com.pigatron.web.cms.image.entity.Image;
import com.pigatron.web.cms.image.entity.ImageQuery;

import java.util.List;

public interface ImageRepositoryCustom {

    List<Image> find(ImageQuery query);

}
