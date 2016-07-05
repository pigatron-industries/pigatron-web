package com.pigatron.web.shop.pub.config;

import com.pigatron.web.admin.config.SubModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublicShopResourceConfig {

    @Autowired
    public void addSubmodule(SubModules publicSubmodules) {
        publicSubmodules.addSubmodule("public.shop");
    }

}
