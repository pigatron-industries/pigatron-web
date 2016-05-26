package com.pigatron.shop.config;

import com.pigatron.admin.config.SubModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/admin-shop.properties")
public class ShopAdminResourceConfig {

    @Autowired
    public void addSubmodule(SubModules adminSubmodules) {
        adminSubmodules.addSubmodule("admin.shop.catalogue");
    }

}
