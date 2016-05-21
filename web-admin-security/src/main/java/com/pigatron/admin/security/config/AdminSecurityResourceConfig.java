package com.pigatron.admin.security.config;

import com.pigatron.admin.config.SubModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/admin-security.properties")
public class AdminSecurityResourceConfig {

    @Autowired
    public void addSubmodule(SubModules submodules) {
        submodules.addSubmodule("admin.security");
    }

}
