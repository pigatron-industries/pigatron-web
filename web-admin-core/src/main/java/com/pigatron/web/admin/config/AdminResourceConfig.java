package com.pigatron.web.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

@Configuration
@PropertySource("classpath:/admin.properties")
public class AdminResourceConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/static/admin/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
		registry.addResourceHandler("/apidocs/**").addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/2.1.8-M1/");
	}

	@Bean
	public WebResources webResources() throws IOException {
		return findWebResources("admin");
	}

	public WebResources findWebResources(String path) throws IOException {
		WebResources webResources = new WebResources();
		ClassLoader cl = this.getClass().getClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);

		Resource[] resources = resolver.getResources("classpath*:/static/" + path + "/*.js");
		for(Resource resource : resources) {
			webResources.addResource(resource.getFilename(), WebResourceType.JS);
		}

		resources = resolver.getResources("classpath*:/static/" + path + "/*.css");
		for(Resource resource : resources) {
			webResources.addResource(resource.getFilename(), WebResourceType.CSS);
		}

		webResources.sort();
		return webResources;
	}

	@Bean
	public SubModules adminSubmodules() {
		return new SubModules();
	}

}
