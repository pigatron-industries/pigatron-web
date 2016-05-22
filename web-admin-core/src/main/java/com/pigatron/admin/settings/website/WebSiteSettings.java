package com.pigatron.admin.settings.website;

import com.pigatron.admin.settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class WebSiteSettings extends Settings {

    public static final String ID = "website";
    public static final String GROUP = "Web";
    public static final String NAME = "Web Site";


    private String title;

    List<Link> topLinks = new ArrayList<>();


    public WebSiteSettings() {
        super(ID, NAME, GROUP);
    }

    private WebSiteSettings(Builder builder) {
        this();
        setTitle(builder.title);
        setTopLinks(builder.topLinks);
    }

    public static Builder aWebSiteSettings() {
        return new Builder();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Link> getTopLinks() {
        return topLinks;
    }

    public void setTopLinks(List<Link> topLinks) {
        this.topLinks = topLinks;
    }



    public static final class Builder {
        private String title;
        private List<Link> topLinks = new ArrayList<>();

        private Builder() {
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withTopLinks(List<Link> val) {
            topLinks = val;
            return this;
        }

        public Builder withTopLink(Link val) {
            topLinks.add(val);
            return this;
        }

        public WebSiteSettings build() {
            return new WebSiteSettings(this);
        }
    }
}
