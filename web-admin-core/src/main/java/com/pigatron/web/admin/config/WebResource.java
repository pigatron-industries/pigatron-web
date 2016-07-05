package com.pigatron.web.admin.config;

public class WebResource implements Comparable<WebResource> {

    private String filename;
    private WebResourceType type;

    private static final String[] sortKeywords = {"polyfill", "lib", "core"};

    public WebResource(String filename, WebResourceType type) {
        this.filename = filename;
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public WebResourceType getType() {
        return type;
    }

    @Override
    public int compareTo(WebResource other) {
        for(String keyword : sortKeywords) {
            if(this.getFilename().contains(keyword) && !other.getFilename().contains(keyword)) {
                return -1;
            } else if(!this.getFilename().contains(keyword) && other.getFilename().contains(keyword)) {
                return 1;
            } else if(this.getFilename().contains(keyword) && other.getFilename().contains(keyword)) {
                return this.getFilename().compareTo(other.getFilename());
            }
        }
        return this.getFilename().compareTo(other.getFilename());
    }
}
