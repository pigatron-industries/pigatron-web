package com.pigatron.admin.domain.entity.sales;

import com.pigatron.admin.domain.entity.catalogue.Product;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class OrderLine {

    @DBRef private Product product;
    //private List<SelectedOption> selectedOptions;

}
