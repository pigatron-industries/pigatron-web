package com.pigatron.shop.domain.entity.sales;

import com.pigatron.shop.domain.entity.catalogue.Product;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class OrderLine {

    @DBRef private Product product;
    //private List<SelectedOption> selectedOptions;

}
