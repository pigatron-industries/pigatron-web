package com.pigatron.shop.catalogue.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.admin.api.View;

public class ProductTaxClass {

    @JsonView(View.Public.class)
    String name;

    @JsonView(View.Public.class)
    float taxPercent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(float taxPercent) {
        this.taxPercent = taxPercent;
    }
}
