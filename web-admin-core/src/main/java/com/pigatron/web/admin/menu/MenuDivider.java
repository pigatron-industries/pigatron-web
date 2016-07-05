package com.pigatron.web.admin.menu;

public class MenuDivider extends MenuItem {

    public MenuDivider() {
        super("divider", null);
    }

    @Override
    public boolean isDivider() {
        return true;
    }
}
