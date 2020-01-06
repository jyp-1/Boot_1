package com.iu.b1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.b1.member.MemberVO;

@Component //객체를 꼭 생성해라아아아아아ㅏ 이해했음
public class NoticeInterceptor extends HandlerInterceptorAdapter{

	
	
	//진입 전 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result = false; 
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO.getId().equals("admin")) {
				result=true;
		}else {
				response.sendRedirect("../member/memberLogin");	//응답을 보내주기(주소 다시치기)
		}
		return result;
	}
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
