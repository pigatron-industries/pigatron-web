package com.pigatron.shop.domain.entity.catalogue.option;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.pigatron.shop.domain.entity.catalogue.Product;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@JsonSubTypes.Type(name = "SelectProduct", value = SelectProduct.class)
public class SelectProduct extends ProductOption {

    @DBRef private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
