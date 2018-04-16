package com.pigatron.web.shop.catalogue.entity.query;

import com.pigatron.web.core.entity.PageableQueryBuilder;

public class ProductQueryBuilder extends PageableQueryBuilder {

    private Boolean hasOptions;
    private Boolean isOption;

    public Boolean getHasOptions() {
        return hasOptions;
    }

    public void setHasOptions(Boolean hasOptions) {
        this.hasOptions = hasOptions;
    }

    public Boolean getIsOption() {
        return isOption;
    }

    public void setIsOption(Boolean isOption) {
        this.isOption = isOption;
    }
}
