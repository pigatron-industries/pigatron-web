package com.pigatron.admin.domain.entity.catalogue.option;


import java.util.List;

public class SelectValue extends ProductOption {

    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
