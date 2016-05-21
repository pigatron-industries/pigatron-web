package com.pigatron.admin.config;


import java.util.ArrayList;
import java.util.List;

public class SubModules {

    private List<String> submodules;

    public SubModules() {
        submodules = new ArrayList<>();
    }

    public List<String> getSubmodules() {
        return submodules;
    }

    public void setSubmodules(List<String> submodules) {
        this.submodules = submodules;
    }

    public void addSubmodule(String name) {
        this.submodules.add(name);
    }
}
