package com.pigatron.admin.config;

import com.pigatron.admin.menu.MenuItem;
import com.pigatron.admin.menu.MenuAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class AdminMenuConfig {

    @Bean
    public MenuItem adminMenu() {
        return new MenuItem("root", "Menu")
                .addSubmenu(configMenu())
                .addSubmenu(developerMenu());
    }

    private MenuItem configMenu() {
        return new MenuItem("config", "Configure")
                .addSubmenu(new MenuItem("settings", "Settings", new MenuAction(MenuAction.TYPE_ROUTE, "settings")));
    }

    private MenuItem developerMenu() {
        return new MenuItem("developer", "Developer")
                .addSubmenu(new MenuItem("apidocs", "Api Docs", new MenuAction(MenuAction.TYPE_JSFUNC,
                                         "admin.open('/apidocs/index.html?url=/api-docs')")));
    }

}
