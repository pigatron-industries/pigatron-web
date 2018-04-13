package com.pigatron.web.admin.config;

import com.pigatron.web.admin.menu.MenuAction;
import com.pigatron.web.admin.menu.MenuItem;
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
                .addSubmenu(new MenuItem("apidocs", "Api Docs", new MenuAction(MenuAction.TYPE_OPEN,
                                         "/apidocs/index.html?url=/api-docs")));
    }

}
