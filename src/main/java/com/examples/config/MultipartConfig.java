package com.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MultipartConfig {

	/**
	 * The XML equivalent of MultipartResolver 
	 * <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
	 * 
	 * @return
	 */

	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

}