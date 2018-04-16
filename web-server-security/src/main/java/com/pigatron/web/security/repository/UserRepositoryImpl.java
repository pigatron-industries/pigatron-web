package com.pigatron.web.security.repository;

import com.pigatron.web.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<User> query(Query query) {
        return mongoOperations.find(query, User.class);
    }

}
