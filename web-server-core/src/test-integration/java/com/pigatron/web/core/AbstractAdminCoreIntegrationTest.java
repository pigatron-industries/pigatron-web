package com.pigatron.web.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AbstractAdminCoreIntegrationTest {

    public static final String CONTENTTYPE_APPLICATION_JSON = "application/json";
    @Value("${url.admin}")
    private String adminUrl;

    @Value("${url.public}")
    private String publicUrl;

    @Value("${local.server.port}")
    private String serverPort;

    protected String adminApiUrl;
    protected String publicApiUrl;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ApplicationEventPublisher publisher;

    ObjectMapper mapper = new ObjectMapper();


    private String getAdminApiUrl() {
        return "http://localhost:" + serverPort + "/" + adminUrl + "/api";
    }

    private String getPublicApiUrl() {
        return "http://localhost:" + serverPort + (publicUrl.isEmpty()?"":"/") + publicUrl + "/api";
    }

    private void setApiUrl(String apiUrl) {
        adminApiUrl = getAdminApiUrl() + apiUrl;
        publicApiUrl = getPublicApiUrl() + apiUrl;
    }

    protected void dbSetup() {
        mongoTemplate.getDb().dropDatabase();
        publisher.publishEvent(new ContextRefreshedEvent(context)); //force initial data setup
    }

    protected void setup() {
        setup(null);
    }

    protected void setup(String apiUrl) {
        if(apiUrl != null) {
            setApiUrl(apiUrl);
        }
        dbSetup();
    }

    protected String toJson(Object o) throws JsonProcessingException {
        return mapper.writeValueAsString(o);
    }

}
