package com.pigatron.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ro.isdc.wro.model.WroModel;
import ro.isdc.wro.model.group.Group;
import ro.isdc.wro.model.resource.Resource;
import ro.isdc.wro.model.resource.ResourceType;

@Configuration
public class ShopAdminResourceConfig {

    @Autowired
    public void addWebResources(WroModel wroModel) {
        Group admin = wroModel.getGroups().stream().filter(group -> group.getName().equals("admin")).findFirst().get();

        admin.addResource(Resource.create("/admin/js/categories.js", ResourceType.JS));
    }

}
