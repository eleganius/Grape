package com.example.app.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.app.login.AdminAuthFilter;
import com.example.app.login.UserAuthFilter;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {

	@Override
	public Validator getValidator() {
		var validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	@Bean
	public MessageSource messageSource() {
		var messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("validation");
		return messageSource;
	}

	@Bean
	public FilterRegistrationBean<AdminAuthFilter> adminAuthFilter() {
		var bean = new FilterRegistrationBean<AdminAuthFilter>(new AdminAuthFilter());
		bean.addUrlPatterns("/admin/user/list");
		return bean;
	}

	@Bean
	public FilterRegistrationBean<UserAuthFilter> studentAuthFilter() {
		var bean = new FilterRegistrationBean<UserAuthFilter>(new UserAuthFilter());
		bean.addUrlPatterns("/user/article/*");
		bean.addUrlPatterns("/user/user/*");
		return bean;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:uploads/");
	}

}
