package com.pigatron.admin.config;

import com.pigatron.admin.menu.MenuItem;
import com.pigatron.admin.menu.MenuAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminMenuConfig {

    @Bean
    public MenuItem adminMenu() {
        MenuItem adminMenu = new MenuItem("root", "Menu")
            .addSubmenu(homeMenu())
            .addSubmenu(catalogueMenu())
            .addSubmenu(logoutMenu());
        return adminMenu;
    }

    private MenuItem homeMenu() {
        MenuItem homeMenu = new MenuItem("home", "Home", new MenuAction(MenuAction.TYPE_ROUTE, "home"));
        return homeMenu;
    }

    private MenuItem catalogueMenu() {
        MenuItem catalogueMenu = new MenuItem("catalogue", "Catalogue");
        catalogueMenu.addSubmenu(new MenuItem("products", "Products", new MenuAction(MenuAction.TYPE_ROUTE, "products")));
        catalogueMenu.addSubmenu(new MenuItem("categories", "Categories", new MenuAction(MenuAction.TYPE_ROUTE, "categories")));
        return catalogueMenu;
    }

    private MenuItem logoutMenu() {
        MenuItem logoutMenu = new MenuItem("logout", "Logout", new MenuAction(MenuAction.TYPE_JSFUNC, "logout()"));
        return logoutMenu;
    }

}
