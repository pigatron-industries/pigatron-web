package com.pigatron.shop.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pigatron.shop.domain.entity.catalogue.option.ProductOption;
import com.pigatron.shop.domain.entity.catalogue.option.ProductOptionMixIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityConfig {

    @Autowired
    public void objectMapper(ObjectMapper objectMapper) {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);

        // using mixins allow for external plugins to add their own subtypes
        objectMapper.addMixIn(ProductOption.class, ProductOptionMixIn.class);
    }

}
