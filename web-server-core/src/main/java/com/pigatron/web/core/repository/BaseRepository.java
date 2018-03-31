package com.pigatron.web.core.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T> extends Repository<T, String> {
    Optional<T> findById(String id);
    List<T> findAll();
    <S extends T> S save(S entity);
    void deleteAll();
    void deleteById(String id);
}
