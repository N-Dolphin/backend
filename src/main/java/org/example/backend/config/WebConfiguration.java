package org.example.backend.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration {



    private final JwtAuthenticateFilter jwtAuthenticateFilter;

    @Bean
    protected CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration= new CorsConfiguration();

        configuration.addAllowedHeader("*");
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.addAllowedMethod("*");


        UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);

        return  source;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(cors-> cors.configurationSource(corsConfigurationSource()))
                .csrf(CsrfConfigurer::disable)
                .httpBasic(HttpBasicConfigurer::disable)
                .authorizeHttpRequests(
                        (requests) ->
                                requests
                                        .requestMatchers("/api/*/auth/**", "/oauth2**", "/").permitAll()
                                        .requestMatchers( "/api/*/users/**").hasRole("USER")
                                        .requestMatchers( "/api/*/admin/**").hasRole("USER")
                                        .anyRequest()
                                        .authenticated()).exceptionHandling(exceptionHandling-> exceptionHandling.authenticationEntryPoint(new FailedAuthenticationEntryPoint()))
                .sessionManagement(
                        (session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))


                .addFilterBefore(jwtAuthenticateFilter, UsernamePasswordAuthenticationFilter.class)
        ;


        return  http.build();
    }

    class FailedAuthenticationEntryPoint implements AuthenticationEntryPoint{

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("{\"code\": \"NP\" , \"message\": \"No Permission.\"}");
           }
    }


}
