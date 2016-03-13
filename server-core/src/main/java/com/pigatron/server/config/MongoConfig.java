package com.pigatron.server.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongodb.name}")
    private String dbName;

    @Value("${mongodb.host}")
    private String dbHost;

    @Value("${mongodb.port}")
    private int dbPort;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(dbHost, dbPort);
    }
}
