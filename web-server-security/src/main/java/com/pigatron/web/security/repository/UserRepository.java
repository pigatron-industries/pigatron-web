package com.pigatron.web.security.repository;

import com.pigatron.web.core.repository.BaseRepository;
import com.pigatron.web.security.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUsername(String username);
    Optional<User> findByTokenSeries(String tokenSeries);
}
