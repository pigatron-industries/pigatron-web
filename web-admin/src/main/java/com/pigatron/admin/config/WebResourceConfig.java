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
import ro.isdc.wro.model.WroModelInspector;
import ro.isdc.wro.model.group.Group;
import ro.isdc.wro.model.resource.Resource;
import ro.isdc.wro.model.resource.ResourceType;
import ro.isdc.wro.model.resource.processor.factory.ConfigurableProcessorsFactory;

import java.util.Properties;

@Configuration
@PropertySource("classpath:/web-admin.properties")
public class WebResourceConfig {

	public static final String ADMIN_GROUP = "admin";
	public static final String URL_PATTERN = "/wro/*";
	public static final String PROP_PREFIX = "wro.";

	private WroModel wroModel;

	@Bean
	@Autowired
	public WroModel wroModel() {
		wroModel = new WebResourceXmlModelFactory().create();
		return wroModel;
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
		fr.addUrlPatterns(URL_PATTERN);
		return fr;
	}

	public void addResource(String location, ResourceType type) {
		Group admin = new WroModelInspector(wroModel).getGroupByName(ADMIN_GROUP);
		admin.addResource(Resource.create(location, type));

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
		return prop;
	}

	private void addProperty(Environment env, Properties properties, String name) {
		String value = env.getProperty(PROP_PREFIX + name);
		if (value != null) {
			properties.put(name, value);
		}
	}

}
