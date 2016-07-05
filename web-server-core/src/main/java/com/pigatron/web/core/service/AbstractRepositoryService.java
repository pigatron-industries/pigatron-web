package com.pigatron.web.core.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public abstract class AbstractRepositoryService<T> implements RepositoryService<T> {

	protected MongoRepository<T, String> repository;

	public AbstractRepositoryService(MongoRepository<T, String> repository) {
		this.repository = repository;
	}

	@Override
	public List<T> findAll(Sort order) {
		return repository.findAll(order);
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
