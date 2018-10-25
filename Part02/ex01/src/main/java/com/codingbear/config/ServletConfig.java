package com.codingbear.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc // 스프링 MVC와 관련된 설정 지정합니다.
@ComponentScan(basePackages = {"com.codingbear.controller", "com.codingbear.exception"}) 
public class ServletConfig implements WebMvcConfigurer {

	// 뷰 리졸버 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	
	// 리소스 위치를 지정합니다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1204 * 1204 * 10); // 1204 * 1204 * 10 bytes = 10MB
		resolver.setMaxUploadSizePerFile(1024 *  1024 * 2); // 1024 * 1024 * 2 bytes = 2MB
		resolver.setMaxInMemorySize(1024 * 1024); // 1MB
		resolver.setUploadTempDir(new FileSystemResource("D:\\upload\\tmp"));
		resolver.setDefaultEncoding("UTF-8");
		
		return resolver;
	}
}
