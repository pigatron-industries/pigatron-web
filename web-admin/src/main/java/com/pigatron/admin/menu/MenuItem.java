package com.pigatron.admin.menu;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MenuItem {

    private String id;
    private String name;
    private MenuAction action;
    private List<MenuItem> submenus;


    public MenuItem(String id, String name) {
        this.id = id;
        this.name = name;
        this.submenus = new ArrayList<>();
    }

    public MenuItem(String id, String name, MenuAction action) {
        this(id, name);
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<MenuItem> submenus) {
        this.submenus = submenus;
    }

    public MenuItem addSubmenu(MenuItem submenu) {
        submenus.add(submenu);
        return this;
    }

    public MenuItem addSubmenu(int index, MenuItem submenu) {
        submenus.add(index, submenu);
        return this;
    }

    public MenuAction getAction() {
        return action;
    }

    public void setAction(MenuAction action) {
        this.action = action;
    }

    public boolean isDivider() {
        return false;
    }

    public Optional<MenuItem> findMenuById(String id) {
        return flatten().filter(menuItem -> menuItem.getId().equals(id)).findFirst();
    }

    private Stream<MenuItem> flatten() {
        return Stream.concat(Stream.of(this), submenus.stream().flatMap(MenuItem::flatten));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("submenus", submenus)
                .toString();
    }
}
