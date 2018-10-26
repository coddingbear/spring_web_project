package com.codingbear.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:config.properties")
@MapperScan(basePackages = {"org.zerock.mapper"})
public class RootConfig {
	
	@Value("${database.driverClassName}") 
	private String driverClassName;
	@Value("${database.jdbcUrl}") 
	private String jdbcUrl;
	@Value("${database.username}") 
	private String username;
	@Value("${database.password}") 
	private String password;
	
	 @Bean
	 public DataSource dataSource() {
		 
		 HikariConfig hikariConfig = new HikariConfig();
		 hikariConfig.setDriverClassName(driverClassName);
		 hikariConfig.setJdbcUrl(jdbcUrl);
		 hikariConfig.setUsername(username);
		 hikariConfig.setPassword(password);
		 
		 HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		 
		 return dataSource;
	 }
	 
	 @Bean
	 public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	 }
}
