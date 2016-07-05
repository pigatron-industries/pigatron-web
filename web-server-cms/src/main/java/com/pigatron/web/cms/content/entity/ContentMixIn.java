package com.pigatron.web.cms.content.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({
        @JsonSubTypes.Type(name = "Page", value = Page.class),
        @JsonSubTypes.Type(name = "Post", value = Post.class),
        @JsonSubTypes.Type(name = "Block", value = Block.class)
})
public class ContentMixIn {
}
