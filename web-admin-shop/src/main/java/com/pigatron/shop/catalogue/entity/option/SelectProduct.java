package com.pigatron.shop.catalogue.entity.option;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.pigatron.shop.catalogue.entity.Product;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@JsonSubTypes.Type(name = "SelectProduct", value = SelectProduct.class)
public class SelectProduct extends ProductOption {

    @DBRef @JsonIgnoreProperties({"parentProduct"}) private List<Product> products;
    private Boolean multiSelect;

    public SelectProduct() {
        setName("SelectProduct");
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Boolean getMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(Boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    /**
     * Builder
     */
    public static final class SelectProductBuilder {
        private List<Product> products;
        private String name;

        private SelectProductBuilder() {
        }

        public static SelectProductBuilder aSelectProduct() {
            return new SelectProductBuilder();
        }

        public SelectProductBuilder products(List<Product> products) {
            this.products = products;
            return this;
        }

        public SelectProductBuilder product(Product product) {
            if(this.products == null) {
                this.products = new ArrayList<>();
            }
            this.products.add(product);
            return this;
        }

        public SelectProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SelectProduct build() {
            SelectProduct selectProduct = new SelectProduct();
            selectProduct.setProducts(products);
            selectProduct.setName(name);
            return selectProduct;
        }
    }
}
