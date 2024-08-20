package com.Caching.Caching;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CachingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext apc = SpringApplication.run(CachingApplication.class, args);
//		for(String s : apc.getBeanDefinitionNames()){
//			System.out.println(s);
//		}

	}

}
