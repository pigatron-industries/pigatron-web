package com.pigatron.admin.security.repository;

import com.pigatron.admin.security.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    User findByTokenSeries(String tokenSeries);

}
