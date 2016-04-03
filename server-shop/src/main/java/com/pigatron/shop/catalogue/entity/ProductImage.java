package com.pigatron.shop.catalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class ProductImage {

    @DBRef(lazy = true)
    @JsonIgnoreProperties({"mimeType"})
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
