package com.pigatron.admin.shop.config;

import com.pigatron.admin.config.WebResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ro.isdc.wro.model.resource.ResourceType;

@Configuration
public class ShopAdminResourceConfig {

    @Autowired
    private WebResourceConfig webResourceConfig;

    @Autowired
    public void addWebResources() {
        webResourceConfig.addResource("/admin/js/shop-config.js", ResourceType.JS);
        webResourceConfig.addResource("/admin/js/categories.js", ResourceType.JS);
        webResourceConfig.addResource("/admin/js/products.js", ResourceType.JS);
    }

}
