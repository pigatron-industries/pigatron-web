package com.pigatron.admin.settings.website;

public class Link {

    private LinkType type;
    private String title;
    private String location;
    private String cssClass;

    public Link() {
    }

    public Link(LinkType type, String title, String location, String cssClass) {
        this.type = type;
        this.title = title;
        this.location = location;
        this.cssClass = cssClass;
    }

    private Link(Builder builder) {
        setType(builder.linkType);
        setTitle(builder.title);
        setLocation(builder.location);
        setCssClass(builder.cssClass);
    }

    public static Builder aLink() {
        return new Builder();
    }

    public LinkType getType() {
        return type;
    }

    public void setType(LinkType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public static final class Builder {
        private LinkType linkType;
        private String title;
        private String location;
        private String cssClass;

        private Builder() {
        }

        public Builder withLinkType(LinkType val) {
            linkType = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withLocation(String val) {
            location = val;
            return this;
        }

        public Builder withCssClass(String val) {
            cssClass = val;
            return this;
        }

        public Link build() {
            return new Link(this);
        }
    }
}
