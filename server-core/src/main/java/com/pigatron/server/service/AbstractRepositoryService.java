package com.pigatron.server.service;

import com.google.common.collect.Lists;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public abstract class AbstractRepositoryService<T> implements RepositoryService<T> {

	protected PagingAndSortingRepository<T, String> repository;

	public AbstractRepositoryService(PagingAndSortingRepository<T, String> repository) {
		this.repository = repository;
	}

	@Override
	public List<T> findAll(Sort orders) {
		Iterable<T> all = repository.findAll();
		return Lists.newArrayList(all);
	}

	@Override
	public T findOne(String id) {
		return repository.findOne(id);
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}
}
