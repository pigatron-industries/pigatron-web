package com.pigatron.web.cms.content.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.web.core.api.View;
import org.springframework.data.annotation.Id;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Content {

    public static final String CONTENT_BREAK = "<!--more-->";


    @Id
    @JsonView({View.AdminSummary.class, View.Public.class})
    private String id;

    @JsonView(View.AdminSummary.class)
    private String type;

    @JsonView(View.AdminSummary.class)
    private boolean enabled;

    @JsonView(View.Public.class)
    private String content;

    @JsonView(View.PublicSummary.class)
    private String contentPreBreak;


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
        int indexOfBreak = content.indexOf(CONTENT_BREAK);
        if(indexOfBreak != -1) {
            setContentPreBreak(content.substring(0, indexOfBreak));
        }
    }

    public String getContentPreBreak() {
        return contentPreBreak;
    }

    private void setContentPreBreak(String contentPreBreak) {
        this.contentPreBreak = contentPreBreak;
    }
}
