//package com.prowings.interceptor;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Component
//public class RequestLoggingInterceptor extends HandlerInterceptorAdapter{
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		StringBuffer requestURL = request.getRequestURL();
//		
////		Map<String, Object> inputMap = new ObjectMapper().readValue(request.getInputStream(), Map.class);
//		 
//		System.out.println("preHandle => RequestUrl : "+requestURL);
////		System.out.println("Incoming request is " + inputMap);
//		
//        return true;
//	}
//	
//	
//
//}
