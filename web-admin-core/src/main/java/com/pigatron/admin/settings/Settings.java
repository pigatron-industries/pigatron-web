package com.pigatron.admin.settings;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public abstract class Settings {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String group;


    public Settings(String id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }
}
