package com.pigatron.web.pub.config;


import com.pigatron.web.admin.config.AdminResourceConfig;
import com.pigatron.web.admin.config.WebResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;


@Configuration
@PropertySource("classpath:/public.properties")
public class PublicResourceConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AdminResourceConfig resourceConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/static/public/");
    }

    @Bean
    public WebResources publicWebResources() throws IOException {
        return resourceConfig.findWebResources("public");
    }

}
