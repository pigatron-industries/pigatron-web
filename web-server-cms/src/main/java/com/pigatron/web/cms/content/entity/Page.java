package com.pigatron.web.cms.content.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.web.core.api.View;
import org.springframework.data.mongodb.core.index.Indexed;

public class Page extends Content {

    @Indexed(unique = true)
    @JsonView({View.AdminSummary.class, View.Public.class})
    private String urlKey;

    @JsonView({View.AdminSummary.class, View.Public.class})
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


    public static final class Builder {
        private String id;
        private String type;
        private boolean enabled;
        private String content;
        private String urlKey;
        private String title;

        private Builder() {
        }

        public static Builder aPage() {
            return new Builder();
        }

        public Builder withUrlKey(String val) {
            urlKey = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder withContent(String content) {
            this.content = content;
            return this;
        }

        public Page build() {
            Page page = new Page();
            page.setType("Page");
            page.setTitle(title);
            page.setUrlKey(urlKey);
            page.setId(id);
            page.setContent(content);
            page.setEnabled(enabled);
            return page;
        }
    }
}
