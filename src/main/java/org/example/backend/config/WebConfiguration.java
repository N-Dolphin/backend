package org.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

@Configuration
public class WebConfiguration {

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration= new CorsConfiguration();
        configuration.setAllowedMethods(List.of("GET", "POST","PATCH","DELETE"));
        configuration.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/v1/**",configuration);
        return source;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
                .authorizeHttpRequests(
                        (requests) -> requests
                                    .anyRequest()
                                    .permitAll());
        return  http.build();
    }

}
