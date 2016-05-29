package com.pigatron.cms.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pigatron.cms.content.entity.Content;
import com.pigatron.cms.content.entity.ContentMixIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CmsEntityConfig {

    @Autowired
    public void objectMapper(ObjectMapper objectMapper) {
        objectMapper.addMixIn(Content.class, ContentMixIn.class);
    }

}
