package com.pigatron.shop.catalogue.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
public class ProductCategory {

    public static final String ROOT_ID = "root";
    public static final String ROOT_NAME = "Shop";

    @Id private String id;
    @Indexed @NotNull private String name;
    @DBRef(lazy=true) private Image image;
    @DBRef private List<ProductCategory> subcategories;

    public ProductCategory() {
        this.subcategories = new ArrayList<>();
    }

    public ProductCategory(String id, String name) {
        this.id = id;
        this.name = name;
        this.subcategories = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<ProductCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<ProductCategory> subcategories) {
        this.subcategories = subcategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductCategory that = (ProductCategory) o;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
