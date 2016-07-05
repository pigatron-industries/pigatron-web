package com.pigatron.cms.pub.config;

import com.pigatron.web.admin.config.SubModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublicCmsResourceConfig {

    @Autowired
    public void addSubmodule(SubModules publicSubmodules) {
        publicSubmodules.addSubmodule("public.cms");
    }

}
