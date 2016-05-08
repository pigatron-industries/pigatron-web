package com.pigatron.pub.config;


import com.pigatron.admin.config.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class PublicResourceConfig {

    @Autowired
    public void addWebResources(ResourceConfig resourceConfig) throws IOException {
        resourceConfig.addResources("wro_public.json");
    }

}
