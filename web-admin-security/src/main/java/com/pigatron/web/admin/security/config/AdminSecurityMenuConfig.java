package com.pigatron.web.admin.security.config;

import com.pigatron.web.admin.menu.MenuAction;
import com.pigatron.web.admin.menu.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminSecurityMenuConfig {

    @Autowired
    public void addMenuItems(MenuItem adminMenu) {
        adminMenu.findMenuById("config").get().addSubmenu(new MenuItem("userss", "Users", new MenuAction(MenuAction.TYPE_ROUTE, "users")));
        adminMenu.addSubmenu(logoutMenu());
    }

    private MenuItem logoutMenu() {
        MenuItem logoutMenu = new MenuItem("logout", "Logout", new MenuAction(MenuAction.TYPE_JSFUNC, "admin.logout()"));
        return logoutMenu;
    }

}
