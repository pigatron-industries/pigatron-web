package com.pigatron.pub.config;


import com.pigatron.admin.config.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

@Configuration
@PropertySource("classpath:/public.properties")
public class PublicResourceConfig extends WebMvcConfigurerAdapter {

    @Autowired
    public void addWebResources(ResourceConfig resourceConfig) throws IOException {
        resourceConfig.addResources("wro_public.json");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/static/public/");
    }

}
