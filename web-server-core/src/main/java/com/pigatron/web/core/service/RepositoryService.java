package com.pigatron.web.core.service;

import com.pigatron.web.core.entity.PageableQueryBuilder;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface RepositoryService<T> {
	@Deprecated
	List<T> findAll(Sort orders);
	List<T> query(PageableQueryBuilder query);
	T findById(String id);
	T save(T entity);
	void deleteAll();
	void delete(String id);
}
