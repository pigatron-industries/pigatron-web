package com.pigatron.web.security.repository;

import com.pigatron.web.security.entity.User;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> query(Query query);
}
