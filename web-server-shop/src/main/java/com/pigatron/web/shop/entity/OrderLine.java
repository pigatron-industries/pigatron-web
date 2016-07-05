package com.pigatron.web.shop.entity;

import com.pigatron.web.shop.catalogue.entity.Product;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class OrderLine {

    @DBRef private Product product;
    //private List<SelectedOption> selectedOptions;

}
