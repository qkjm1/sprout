package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] origins = {
            "http://localhost:3000",
            "http://127.0.0.1:3000",
            "http://localhost:3001"
        };

        // REST API
        registry.addMapping("/api/**")
                .allowedOrigins(origins) // 한번에 여러 개
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","PATCH")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);

        // SSE (이벤트 스트림)
        registry.addMapping("/sse/**")
                .allowedOrigins(origins)
                .allowedMethods("GET","OPTIONS")  // SSE는 주로 GET
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
