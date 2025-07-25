package com.Horizon.MCS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class Cors {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of(
                "https://poetic-zabaione-b6470e.netlify.app", // <-- dominio de tu front
                "http://127.0.0.1:5500",
                "http://localhost:5500"
        ));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*"); // permite GET, POST, PUT, DELETE, OPTIONS
        config.setMaxAge(3600L);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
