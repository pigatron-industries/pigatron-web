package com.pigatron.shop.pub.config;

import com.pigatron.admin.config.SubModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublicShopResourceConfig {

    @Autowired
    public void addSubmodule(SubModules publicSubmodules) {
        publicSubmodules.addSubmodule("public.shop");
    }

}
