package com.pigatron.admin.config;

public class WebResource implements Comparable<WebResource> {

    private String filename;
    private WebResourceType type;

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
        if (this.getFilename().contains("lib") && !other.getFilename().contains("lib")) {
            return -1;
        } else if (!this.getFilename().contains("lib") && other.getFilename().contains("lib")) {
            return 1;
        } else {
            if(this.getFilename().contains("core") && !other.getFilename().contains("core")) {
                return -1;
            } else if (!this.getFilename().contains("core") && other.getFilename().contains("core")) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
