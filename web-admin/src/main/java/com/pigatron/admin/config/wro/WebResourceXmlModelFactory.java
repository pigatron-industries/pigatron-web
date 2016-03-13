package com.pigatron.admin.config.wro;


import ro.isdc.wro.model.WroModel;
import ro.isdc.wro.model.factory.WroModelFactory;
import ro.isdc.wro.model.factory.XmlModelFactory;

import java.io.IOException;
import java.io.InputStream;

public class WebResourceXmlModelFactory extends XmlModelFactory implements WroModelFactory {

    @Override
    public WroModel create() {
        return super.create();
    }

    protected InputStream getModelResourceAsStream() throws IOException {
        return getModelResourceAsStream("/wro.xml");
    }

    protected InputStream getModelResourceAsStream(String resourceLocation) throws IOException {
        final InputStream stream = getClass().getResourceAsStream(resourceLocation);

        if (stream == null) {
            throw new IOException("Invalid resource requested: " + resourceLocation);
        }

        return stream;
    }

}
