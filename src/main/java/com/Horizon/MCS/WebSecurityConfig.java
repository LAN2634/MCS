package com.Horizon.MCS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())         // desactiva CSRF
                .cors(cors -> {})                     // activa tu CorsFilter global
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // permite todas las rutas
                )
                .build();
    }
}
