package com.pigatron.shop.config;

import com.pigatron.admin.config.ResourceConfig;
import com.pigatron.admin.config.wro.SubModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ShopAdminResourceConfig {

    @Autowired
    private ResourceConfig resourceConfig;

    @Autowired
    public void addSubmodule(SubModules submodules) {
        submodules.addSubmodule("admin.shop.catalogue");
    }

    @Autowired
    public void addWebResources() throws IOException {
        resourceConfig.addResources("wro_shop.json");
    }

}
