package com.pigatron.web.admin.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebResources {

    private List<WebResource> webResources;

    public WebResources() {
        this.webResources = new ArrayList<>();
    }

    public void addResource(String filename, WebResourceType type) {
        this.webResources.add(new WebResource(filename, type));
    }

    public List<WebResource> getWebResources() {
        return webResources;
    }

    public void sort() {
        Collections.sort(webResources);
    }
}
