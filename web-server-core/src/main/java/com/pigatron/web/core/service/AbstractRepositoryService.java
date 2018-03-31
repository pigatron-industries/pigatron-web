package com.pigatron.web.core.service;

import com.pigatron.web.core.exception.ResourceNotFoundException;
import com.pigatron.web.core.repository.BaseRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public abstract class AbstractRepositoryService<T> implements RepositoryService<T> {

	protected BaseRepository<T> repository;

	public AbstractRepositoryService(BaseRepository<T> repository) {
		this.repository = repository;
	}

	@Override
	public List<T> findAll(Sort order) {
		//TODO sort order
		return repository.findAll();
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
