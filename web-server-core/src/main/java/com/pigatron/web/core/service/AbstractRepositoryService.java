package com.pigatron.web.core.service;

import com.pigatron.web.core.entity.PageableQueryBuilder;
import com.pigatron.web.core.exception.ResourceNotFoundException;
import com.pigatron.web.core.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

public abstract class AbstractRepositoryService<T> implements RepositoryService<T> {

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	protected BaseRepository<T> repository;

	@Override
	@Deprecated
	public List<T> findAll(Sort order) {
		//TODO sort order
		return repository.findAll();
	}

	@Override
	public List<T> query(PageableQueryBuilder queryBuilder) {
		//return mongoOperations.find(queryBuilder.build(), typeClass);
		return repository.query(queryBuilder.build());
	}

	@Override
	public T findById(String id) {
		return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
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
		repository.deleteById(id);
	}
}
