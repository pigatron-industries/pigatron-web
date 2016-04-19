package com.pigatron.server.security.repository;

import com.pigatron.server.security.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    User findByTokenSeries(String tokenSeries);

}
