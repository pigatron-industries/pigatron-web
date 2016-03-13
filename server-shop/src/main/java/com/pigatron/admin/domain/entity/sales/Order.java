package com.pigatron.admin.domain.entity.sales;


import org.springframework.data.annotation.Id;

import java.util.List;

public class Order {

    @Id private String id;

    private List<OrderLine> orderLines;

}
