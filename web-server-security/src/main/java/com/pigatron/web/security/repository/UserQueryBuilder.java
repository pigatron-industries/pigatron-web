package com.pigatron.web.security.repository;

import com.pigatron.web.core.entity.PageableQueryBuilder;
import org.springframework.data.mongodb.core.query.Query;

import java.util.regex.Pattern;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class UserQueryBuilder extends PageableQueryBuilder {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public Query build() {
        Query query = super.build();
        if(username != null) {
            query.addCriteria(where("username").regex(".*" + username + ".*"));
        }
        return query;
    }
}
