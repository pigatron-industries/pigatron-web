package com.pigatron.admin.config.wro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.isdc.wro.model.WroModel;
import ro.isdc.wro.model.factory.WroModelFactory;

@Component
public class WebResourceBeanModelFactory implements WroModelFactory {

    @Autowired
    private WroModel wroModel;

    @Override
    public WroModel create() {
        return wroModel;
    }

    @Override
    public void destroy() {
    }
}
