package com.pigatron.web.security.repository;

import com.pigatron.web.core.repository.BaseRepository;
import com.pigatron.web.security.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
    User findByUsername(String username);
    User findByTokenSeries(String tokenSeries);
}
