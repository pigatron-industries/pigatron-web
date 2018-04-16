package com.pigatron.web.core.repository;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;


@NoRepositoryBean
public interface BaseRepository<T> extends MongoRepository<T, String> {
    List<T> query(Query query);
}
