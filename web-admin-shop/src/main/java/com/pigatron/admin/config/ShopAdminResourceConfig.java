package com.pigatron.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ro.isdc.wro.model.WroModel;
import ro.isdc.wro.model.resource.ResourceType;

@Configuration
public class ShopAdminResourceConfig extends WebResourceConfig {

    @Autowired
    public void addWebResources(WroModel wroModel) {
        addResource("/admin/js/categories.js", ResourceType.JS);
        addResource("/admin/js/products.js", ResourceType.JS);
    }

}
