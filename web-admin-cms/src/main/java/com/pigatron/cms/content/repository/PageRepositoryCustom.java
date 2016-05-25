package com.pigatron.cms.content.repository;

import com.pigatron.cms.content.entity.Page;
import com.pigatron.cms.content.entity.PageQuery;

import java.util.List;

public interface PageRepositoryCustom {

    List<Page> find(PageQuery query);

}
