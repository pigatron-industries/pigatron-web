package com.pigatron.shop.order.entity;

import com.pigatron.shop.catalogue.entity.Product;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class OrderLine {

    @DBRef private Product product;
    //private List<SelectedOption> selectedOptions;

}
