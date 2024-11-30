package com.financeModule.CRUD;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all routes
                .allowedOrigins("https://tribu-c-2024-2c.onrender.com/") // Replace with your front-end domain
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow the methods you need
                .allowedHeaders("Content-Type", "Authorization") // Allow headers if needed
                .allowCredentials(true); // Allow cookies or credentials if needed
    }
}

