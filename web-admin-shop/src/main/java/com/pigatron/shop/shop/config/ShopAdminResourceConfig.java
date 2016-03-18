package com.pigatron.shop.shop.config;

import com.pigatron.admin.config.WebResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ShopAdminResourceConfig {

    @Autowired
    private WebResourceConfig webResourceConfig;

    @Autowired
    public void addWebResources() throws IOException {
        webResourceConfig.addResources("wro_shop.json");
    }

}
