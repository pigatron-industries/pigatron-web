package com.pigatron.shop.catalogue.entity.option;


import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.admin.api.View;

import java.util.List;

public class SelectValue extends ProductOption {

    @JsonView(View.Public.class)
    private List<String> values;

    public SelectValue() {
        setName("SelectValue");
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
