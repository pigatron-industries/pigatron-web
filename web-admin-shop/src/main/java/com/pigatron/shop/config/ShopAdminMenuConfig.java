package com.pigatron.shop.config;

import com.pigatron.admin.menu.MenuAction;
import com.pigatron.admin.menu.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopAdminMenuConfig {

    @Autowired
    public void addMenuItems(MenuItem adminMenu) {
        adminMenu
                .addSubmenu(0, homeMenu())
                .addSubmenu(1, catalogueMenu());
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
}
