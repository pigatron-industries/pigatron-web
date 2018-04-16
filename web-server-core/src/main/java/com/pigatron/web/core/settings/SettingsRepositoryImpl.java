package com.pigatron.web.core.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SettingsRepositoryImpl implements SettingsRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Settings> query(Query query) {
        return mongoOperations.find(query, Settings.class);
    }

}
