package com.pigatron.cms.content.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.admin.api.View;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

public class Page {

    @Id
    @JsonView(View.Summary.class)
    private String id;

    @JsonView(View.Summary.class)
    private boolean staticPage;

    @JsonView(View.Summary.class)
    private boolean published;

    @JsonView(View.Summary.class)
    private LocalDateTime publishedDateTime;

    @Indexed(unique = true)
    @JsonView(View.Summary.class)
    private String urlKey;

    @JsonView(View.Summary.class)
    private String title;

    private String content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public LocalDateTime getPublishedDateTime() {
        return publishedDateTime;
    }

    public void setPublishedDateTime(LocalDateTime publishedDateTime) {
        this.publishedDateTime = publishedDateTime;
    }

    public boolean isStaticPage() {
        return staticPage;
    }

    public void setStaticPage(boolean staticPage) {
        this.staticPage = staticPage;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
