package org.codingbear.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * RootConfig 클래스
 */
@Configuration
@ComponentScan(basePackages= {"org.codingbear.sample"})
public class RootConfig {

}
