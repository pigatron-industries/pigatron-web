package com.pigatron.admin.config;

import com.pigatron.admin.config.wro.WebResourceModelManagerFactory;
import com.pigatron.admin.config.wro.WebResourceXmlModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ro.isdc.wro.config.jmx.ConfigConstants;
import ro.isdc.wro.http.ConfigurableWroFilter;
import ro.isdc.wro.model.WroModel;
import ro.isdc.wro.model.resource.processor.factory.ConfigurableProcessorsFactory;

import java.util.Properties;

@Configuration
@PropertySource("classpath:/application-admin.properties")
public class WebResourceConfig {

	@Bean
	@Autowired
	public WroModel wroModel() {
		return new WebResourceXmlModelFactory().create();
	}

	@Bean
	FilterRegistrationBean webResourceOptimizer(Environment env, WebResourceModelManagerFactory webResourceModelManagerFactory) {
		FilterRegistrationBean fr = new FilterRegistrationBean();
		ConfigurableWroFilter filter = new ConfigurableWroFilter();
		Properties props = buildWroProperties(env);
		webResourceModelManagerFactory.setProperties(props);
		filter.setProperties(props);
		filter.setWroManagerFactory(webResourceModelManagerFactory);
		fr.setFilter(filter);
		fr.addUrlPatterns("/wro/*");
		return fr;
	}

	private static final String[] OTHER_WRO_PROP = new String[] {
			ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS,
			ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS
	};

	private Properties buildWroProperties(Environment env) {
		Properties prop = new Properties();
		for (ConfigConstants c : ConfigConstants.values()) {
			addProperty(env, prop, c.name());
		}
		for (String name : OTHER_WRO_PROP) {
			addProperty(env, prop, name);
		}
		//log.debug("Wro4J properties {}", prop);
		return prop;
	}

	private void addProperty(Environment env, Properties properties, String name) {
		String value = env.getProperty("wro." + name);
		if (value != null) {
			properties.put(name, value);
		}
	}

}
