package com.pigatron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
@PropertySource("classpath:/default.properties")
public class Application {

	static ApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(Application.class, args);
	}

	private static void close() {
		((AbstractApplicationContext)context).close();
	}

}
