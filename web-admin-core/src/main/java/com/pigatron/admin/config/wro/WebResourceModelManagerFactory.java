package com.pigatron.admin.config.wro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.isdc.wro.manager.factory.ConfigurableWroManagerFactory;
import ro.isdc.wro.model.factory.WroModelFactory;

import java.util.Properties;

@Component
public class WebResourceModelManagerFactory extends ConfigurableWroManagerFactory {

	private Properties props;

	@Autowired
	private WebResourceBeanModelFactory webResourceBeanModelFactory;

	@Override
	protected Properties newConfigProperties() {
		return props;
	}

	@Override
	protected WroModelFactory newModelFactory() {
		return webResourceBeanModelFactory;
	}

	public void setProperties(Properties props) {
		this.props = props;
	}
}
