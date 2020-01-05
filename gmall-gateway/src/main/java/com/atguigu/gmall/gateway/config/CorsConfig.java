package com.atguigu.gmall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author lzzzzz
 * @create 2020-01-05 22:06
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter getCorsWebFilter(){
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //添加请求源，允许那些可以访问，不要设为*，不然cookie就会失效
        config.addAllowedOrigin("http://localhost:1000");
        config.addAllowedOrigin("http://127.0.0.1:1000");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true);
        configSource.registerCorsConfiguration("/**",config);
        return new CorsWebFilter(configSource);
    }
}
