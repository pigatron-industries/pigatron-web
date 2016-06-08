package com.pigatron.cms.content.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.admin.api.View;
import org.springframework.data.annotation.Id;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Content {

    @Id
    @JsonView({View.Summary.class, View.Public.class})
    private String id;

    @JsonView(View.Summary.class)
    private String type;

    @JsonView(View.Summary.class)
    private boolean enabled;

    @JsonView(View.Public.class)
    private String content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
