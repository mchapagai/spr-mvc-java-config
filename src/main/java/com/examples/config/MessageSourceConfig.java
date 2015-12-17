package com.examples.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
 /**
  * @author mchapagai
  * Internationalization and message.properties scanner
  * Refer to xml-equivalent/servlet-context.xaml
  */
@Configuration
public class MessageSourceConfig {
	
	private static final String MESSAGE_SOURCE_BASE_NAME = "classpath:i18n/messages";
	
	/**
	 * XML equivalent
	 * <bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource" p:basename="classpath:i18n/messages">
     *   <property name="defaultEncoding" value="UTF-8"/>
     * </bean>
	 * @return
	 */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
     
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver result = new SessionLocaleResolver();
        result.setDefaultLocale(Locale.ENGLISH);
        return result;
    }
     
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }
    
}
