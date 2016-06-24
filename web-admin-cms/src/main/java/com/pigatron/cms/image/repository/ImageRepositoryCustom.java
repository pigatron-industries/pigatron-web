package com.pigatron.cms.image.repository;


import com.pigatron.cms.image.entity.Image;
import com.pigatron.cms.image.entity.ImageQuery;

import java.util.List;

public interface ImageRepositoryCustom {

    List<Image> find(ImageQuery query);

}
