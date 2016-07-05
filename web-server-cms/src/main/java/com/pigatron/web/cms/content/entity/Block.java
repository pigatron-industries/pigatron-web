package com.pigatron.web.cms.content.entity;


import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.web.core.api.View;

public class Block extends Content {

    @JsonView(View.Summary.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
