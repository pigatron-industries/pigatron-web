package com.pigatron.web.admin.security.config;

import com.pigatron.web.admin.config.SubModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminSecurityResourceConfig {

    @Autowired
    public void addSubmodule(SubModules adminSubmodules) {
        adminSubmodules.addSubmodule("admin.security");
    }

}
