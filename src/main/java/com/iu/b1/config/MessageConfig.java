package com.iu.b1.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@Configuration
public class MessageConfig implements WebMvcConfigurer{

	@Bean
	public LocaleResolver localeresolver() {
		
		//SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver(); 
		//sessionLocaleResolver.setDefaultLocale(Locale.KOREAN);
		
		
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);
		cookieLocaleResolver.setCookieName("lang");
		return cookieLocaleResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor getLocale() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		
		registry.addInterceptor(getLocale()).addPathPatterns("/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	
}
