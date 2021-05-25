package com.brillio.customer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RestController
public class CustomerConfig {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
//@Bean
//	public InternalResourceViewResolver getInternalResourceViewResolver() {
//	InternalResourceViewResolver resolver=new InternalResourceViewResolver();
//		resolver.setPrefix("WEB_INF/view");
//		resolver.setSuffix(".*");
//		return resolver;
//	}

}
