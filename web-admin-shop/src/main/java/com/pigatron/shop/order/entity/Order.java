package com.pigatron.shop.order.entity;


import org.springframework.data.annotation.Id;

import java.util.List;

public class Order {

    @Id private String id;

    private List<OrderLine> orderLines;

}
