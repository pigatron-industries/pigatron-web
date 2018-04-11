package com.pigatron.web.admin.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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

    @JsonIgnore
    public List<MenuItem> getAllMenus() {
        List<MenuItem> allSubmenus = submenus.stream()
                .map(MenuItem::getAllMenus)
                .flatMap(Collection::stream)
                .collect(toList());
        allSubmenus.add(this);
        return allSubmenus;
    }

    public void setSubmenus(List<MenuItem> submenus) {
        this.submenus = submenus;
    }

    public MenuItem submenu(MenuItem newMenu) {
        Optional<MenuItem> existing = submenus.stream().filter(s -> s.getId().equals(newMenu.getId())).findFirst();
        if(existing.isPresent()) {
            for(MenuItem newSubmenu : newMenu.getSubmenus()) {
                existing.get().submenu(newSubmenu);
            }
        } else {
            submenus.add(newMenu);
        }
        return this;
    }

    public MenuItem submenuBefore(String beforeId, MenuItem newMenu) {
        int index = 0;
        for(MenuItem submenu : submenus) {
            if(submenu.getId().equals(beforeId)) {
                break;
            }
            index++;
        }
        submenus.add(index, newMenu);
        return this;
    }

    public MenuItem submenuAfter(String afterId, MenuItem newMenu) {
        int index = 0;
        for(MenuItem submenu : submenus) {
            if(submenu.getId().equals(afterId)) {
                break;
            }
            index++;
        }
        if(index + 1 > submenus.size()) {
            submenus.add(0, newMenu);
        } else {
            submenus.add(index + 1, newMenu);
        }
        return this;
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
