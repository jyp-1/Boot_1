package com.iu.b1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.b1.interceptor.CustomInterceptor;
import com.iu.b1.interceptor.MemberInterceptor;

@Configuration//XML 파일
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private CustomInterceptor customInterceptor;
	@Autowired
	private MemberInterceptor MemberInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//interceptor 등록하기 
		registry.addInterceptor(customInterceptor)
		//interceptor를 사용할 URL 패턴 등록
		.addPathPatterns("/member/*")
		/*.addPathPatterns("/member/myPage");*/
		//interceptor를 제외할 URL 패턴 등록
		.excludePathPatterns("/member/memberLogin")
		.excludePathPatterns("/member/memberJoin");
		
		registry.addInterceptor(MemberInterceptor)
		.addPathPatterns("/member/myPage");
		
		
		
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	

	
	
}
