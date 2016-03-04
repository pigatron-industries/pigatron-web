package com.pigatron.shop.domain.entity.catalogue;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {

    public static final String ROOT_ID = "root";

    @Id private String id;
    @Indexed private String name;
    @DBRef private List<ProductCategory> subcategories;

    public ProductCategory() {
    }

    public ProductCategory(String id, String name) {
        this.id = id;
        this.name = name;
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

    public List<ProductCategory> getSubcategories() {
        if(subcategories == null) {
            subcategories = new ArrayList<ProductCategory>();
        }
        return subcategories;
    }

    public void setSubcategories(List<ProductCategory> subcategories) {
        this.subcategories = subcategories;
    }
}
