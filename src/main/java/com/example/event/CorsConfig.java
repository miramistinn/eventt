package com.example.event;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/create")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowCredentials(true);

        registry.addMapping("/read/client")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowCredentials(true);
        registry.addMapping("/create/application")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowCredentials(true);

    }
}