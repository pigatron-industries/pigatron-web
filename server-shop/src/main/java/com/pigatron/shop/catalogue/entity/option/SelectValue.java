package com.pigatron.shop.catalogue.entity.option;


import java.util.List;

public class SelectValue extends ProductOption {

    public SelectValue() {
        setName("SelectValue");
    }

    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
