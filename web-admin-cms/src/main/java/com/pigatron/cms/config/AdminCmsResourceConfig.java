package com.pigatron.cms.config;

import com.pigatron.admin.config.SubModules;
import com.pigatron.admin.menu.MenuAction;
import com.pigatron.admin.menu.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/admin-cms.properties")
public class AdminCmsResourceConfig {

    @Autowired
    public void addSubmodule(SubModules adminSubmodules) {
        adminSubmodules.addSubmodule("admin.cms");
    }

    @Autowired
    public void addMenuItems(MenuItem adminMenu) {
        adminMenu
                .addSubmenu(1, contentMenu());
    }

    private MenuItem contentMenu() {
        MenuItem contentMenu = new MenuItem("content", "Content");
        contentMenu.addSubmenu(new MenuItem("contents", "Content", new MenuAction(MenuAction.TYPE_ROUTE, "contents")));
        return contentMenu;
    }

}
