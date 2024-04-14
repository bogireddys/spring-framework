package com.bogireddy.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringDemoApplication::main).with(TestSpringDemoApplication.class).run(args);
	}

}
