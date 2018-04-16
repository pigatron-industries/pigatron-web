package com.pigatron.web.shop.shipping;

import com.pigatron.web.shop.shipping.entity.ShippingMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class ShippingMethodRepositoryImpl implements ShippingMethodRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<ShippingMethod> query(Query query) {
        return mongoOperations.find(query, ShippingMethod.class);
    }

}
