package com.study.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCorsConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
			.allowedOrigins("http://localhost:5173") // 5173만 허용
			.allowedOriginPatterns("http://localhost:*") //모든 포트 허용
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowedHeaders("Content-Type", "Authorization")
			.exposedHeaders("Location") // 헤더에 location값은 있어도 된다는 것을 의미 
			.allowCredentials(true) // 쿠키 허용
			.maxAge(3600);
	}
}
