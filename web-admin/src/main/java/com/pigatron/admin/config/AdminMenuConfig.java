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
        MenuItem adminMenu = new MenuItem("root", "Menu")
                .addSubmenu(developerMenu())
                .addSubmenu(logoutMenu());
        return adminMenu;
    }

    private MenuItem developerMenu() {
        MenuItem logoutMenu = new MenuItem("developer", "Developer")
                .addSubmenu(new MenuItem("apidocs", "Api Docs", new MenuAction(MenuAction.TYPE_JSFUNC,
                                         "admin.open('/lib/swagger-ui/index.html?url=/api-docs')")));
        return logoutMenu;
    }

    private MenuItem logoutMenu() {
        MenuItem logoutMenu = new MenuItem("logout", "Logout", new MenuAction(MenuAction.TYPE_JSFUNC, "admin.logout()"));
        return logoutMenu;
    }

}
