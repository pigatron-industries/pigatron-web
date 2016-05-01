package com.pigatron.shop.config;

import com.pigatron.admin.config.AdminResourceConfig;
import com.pigatron.admin.config.wro.SubModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;

@Configuration
public class ShopAdminResourceConfig {

    @Autowired
    private AdminResourceConfig adminResourceConfig;

    @Autowired
    public void addSubmodule(SubModules submodules) {
        submodules.addSubmodule("admin.shop.catalogue");
    }

    @Autowired
    public void addWebResources() throws IOException {
        adminResourceConfig.addResources("wro_shop.json");
    }

}
