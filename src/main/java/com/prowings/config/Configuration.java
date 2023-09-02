//package com.prowings.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.prowings.interceptor.RequestLoggingInterceptor;
//
//@Component
//public class Configuration implements WebMvcConfigurer{
//
//	@Autowired
//    private RequestLoggingInterceptor logInterceptor;
// 
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(logInterceptor);
//	}
//
//	
//	
//}
