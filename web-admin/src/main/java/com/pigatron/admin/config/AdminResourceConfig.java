package com.pigatron.admin.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.pigatron.admin.config.wro.SubModules;
import com.pigatron.admin.config.wro.WebResourceModelManagerFactory;
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

import java.io.IOException;
import java.net.URL;
import java.util.*;

@Configuration
@PropertySource("classpath:/admin.properties")
public class AdminResourceConfig {

	public static final String ADMIN_GROUP = "admin";
	public static final String URL_PATTERN = "/wro/*";
	public static final String PROP_PREFIX = "wro.";

	private WroModel wroModel;

	@Bean
	public WroModel wroModel() throws IOException {
		wroModel = new WroModel();
		addResources("wro.json");
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

	@Bean
	public SubModules submodules() {
		return new SubModules();
	}

	public void addResource(String location, ResourceType type) {
		Group admin = new WroModelInspector(wroModel).getGroupByName(ADMIN_GROUP);
		admin.addResource(Resource.create(location, type));
	}

	public void addResources(String filename) throws IOException {
		String wroConfig = readWroConfig(filename);
		populateWroModel(wroModel, wroConfig);
	}

	private String readWroConfig(String filename) throws IOException {
		URL url = Resources.getResource(filename);
		String text = Resources.toString(url, Charsets.UTF_8);
		return text;
	}

	private void populateWroModel(WroModel wroModel, String jsonConfig) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonConfig);
		WroModelInspector wroModelInspector = new WroModelInspector(wroModel);

		Iterator<Map.Entry<String, JsonNode>> groups = rootNode.fields();
		while(groups.hasNext()) {
			//Group
			Map.Entry<String, JsonNode> group = groups.next();
			Group wroGroup = wroModelInspector.getGroupByName(group.getKey());
			if(wroGroup == null) {
				wroGroup = new Group(group.getKey());
				wroModel.addGroup(wroGroup);
			}

			//Prefix
			String prefix = group.getValue().get("prefix").asText();

			//JS
			if(group.getValue().get("js") != null) {
				Iterator<JsonNode> js = group.getValue().get("js").iterator();
				while (js.hasNext()) {
					String location = prefix + js.next().asText();
					wroGroup.addResource(Resource.create(location, ResourceType.JS));
				}
			}

			//JSX
			if(group.getValue().get("jsx") != null) {
				Iterator<JsonNode> jsx = group.getValue().get("jsx").iterator();
				while (jsx.hasNext()) {
					String location = prefix + jsx.next().asText() + ".js";
					wroGroup.addResource(Resource.create(location, ResourceType.JS));
				}
			}

			//CSS
			if(group.getValue().get("css") != null) {
				Iterator<JsonNode> css = group.getValue().get("css").iterator();
				while (css.hasNext()) {
					String location = prefix + css.next().asText();
					wroGroup.addResource(Resource.create(location, ResourceType.CSS));
				}
			}
		}
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
