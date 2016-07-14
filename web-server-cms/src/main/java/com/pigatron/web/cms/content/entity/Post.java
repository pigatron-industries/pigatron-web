package com.pigatron.web.cms.content.entity;


import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.web.core.api.View;

import java.util.Date;

public class Post extends Content {

    @JsonView({View.AdminSummary.class, View.Public.class})
    private Date publishedDate;

    @JsonView({View.AdminSummary.class, View.Public.class})
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
