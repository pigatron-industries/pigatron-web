package com.pigatron.cms.content.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.admin.api.View;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.Date;

public class Page extends Content {

    @Indexed(unique = true)
    @JsonView(View.Summary.class)
    private String urlKey;

    @JsonView(View.Summary.class)
    private Date publishedDate;

    @JsonView(View.Summary.class)
    private String title;


    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
