package com.pigatron.shop.catalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pigatron.shop.image.entity.Image;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class ProductImage {

    @DBRef(lazy = true)
    @JsonIgnoreProperties({"mimeType"})
    private Image image;

    private boolean thumbnail;


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(boolean thumbnail) {
        this.thumbnail = thumbnail;
    }
}
