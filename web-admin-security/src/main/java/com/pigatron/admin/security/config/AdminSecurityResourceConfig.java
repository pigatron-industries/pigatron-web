package com.pigatron.admin.security.config;

import com.pigatron.admin.config.AdminResourceConfig;
import com.pigatron.admin.config.wro.SubModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@Configuration
@PropertySource("classpath:/admin-security.properties")
public class AdminSecurityResourceConfig {

    @Autowired
    private AdminResourceConfig adminResourceConfig;

    @Autowired
    public void addSubmodule(SubModules submodules) {
        submodules.addSubmodule("admin.security");
    }

    @Autowired
    public void addWebResources() throws IOException {
        adminResourceConfig.addResources("wro_security.json");
    }

}