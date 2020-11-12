package com.tianyisoft.mymoney.config;

import com.auth0.jwt.algorithms.Algorithm;
import com.tianyisoft.mymoney.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author tianyi
 */
@Configuration
public class JwtConfig implements WebMvcConfigurer {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public Algorithm hmac256() {
        return Algorithm.HMAC256(secret);
    }

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor()).excludePathPatterns("/auth/**").order(0);
    }
}
