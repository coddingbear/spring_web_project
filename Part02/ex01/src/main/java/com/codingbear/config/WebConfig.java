package com.codingbear.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	// 루트 컨텍스트 클래스 지정
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	// 서블릿 컨텍스트 클래스를 지정
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletConfig.class };
	}

	// 서블릿 매핑을 지정함.
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
