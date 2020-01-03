package com.iu.b1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component //객체를 꼭 생성해라아아아아아ㅏ 이해했음
public class MemberInterceptor extends HandlerInterceptorAdapter{

	
	
	//진입 전 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result = false; 
		Object object = request.getSession().getAttribute("member");
		if(object !=null) {
				result=true;
		}else {
				response.sendRedirect("./memberLogin");	//응답을 보내주기(주소 다시치기)
		}
		return result;
	}
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
