package org.codingbear.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * WebConfig 클래스
 * web.xml를 대신하는 클래스 작성
 */
public class WebConfig extends 
	AbstractAnnotationConfigDispatcherServletInitializer {

	// 'root-context.xml'를 대신하는 클래스를 지정하는 메소드
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	// 'servlet-context.xml'를 대신하는 클래스를 지정하는 메소드
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}

}
