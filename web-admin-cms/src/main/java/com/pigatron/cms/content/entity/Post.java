package com.pigatron.cms.content.entity;


import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.admin.api.View;

import java.util.Date;

public class Post {

    @JsonView(View.Summary.class)
    private String title;

    @JsonView(View.Summary.class)
    private Date publishedDate;


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
