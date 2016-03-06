package com.pigatron.shop.domain.entity.catalogue.option;

import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({
        @JsonSubTypes.Type(name = "SelectProduct", value = SelectProduct.class),
        @JsonSubTypes.Type(name = "SelectValue", value = SelectValue.class)
})
public class ProductOptionMixIn {
}
