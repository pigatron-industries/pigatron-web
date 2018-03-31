package com.pigatron.web.core.service;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface RepositoryService<T> {
	List<T> findAll(Sort orders);
	T findById(String id);
	T save(T entity);
	void deleteAll();
	void delete(String id);
}
