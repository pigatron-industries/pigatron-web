package com.pigatron.web.shop.catalogue.entity.option;

import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({
        @JsonSubTypes.Type(name = "SelectProduct", value = SelectProduct.class),
        @JsonSubTypes.Type(name = "SelectValue", value = SelectValue.class)
})
public class ProductOptionMixIn {
}
