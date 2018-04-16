package com.pigatron.web.shop.shipping;

import com.pigatron.web.shop.shipping.entity.ShippingMethod;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface ShippingMethodRepositoryCustom {
    List<ShippingMethod> query(Query query);
}
