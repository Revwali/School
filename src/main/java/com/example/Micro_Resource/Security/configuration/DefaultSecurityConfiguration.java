package com.example.Micro_Resource.Security.configuration;

import com.example.Micro_Resource.CustomAuthenticatinEntryPoint.CustomBasicAuthenticationEntryPoint;
import com.example.Micro_Resource.CustomAuthentictionFilter.CustomAuthenticationVlidatorFilter;
import com.example.Micro_Resource.CustomAuthentictionFilter.CustomBasicAuthenticationFilter;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class DefaultSecurityConfiguration {
    private CustomAuthenticationVlidatorFilter customAuthenticationVlidatorFilter;
    private CustomBasicAuthenticationFilter customBasicAuthenticationFilter;
    private CustomBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public void setCustomBasicAuthenticationFilter(CustomBasicAuthenticationFilter customBasicAuthenticationFilter) {
        this.customBasicAuthenticationFilter = customBasicAuthenticationFilter;
    }

    @Autowired
    public void setCustomAuthenticationVlidatorFilter(CustomAuthenticationVlidatorFilter customAuthenticationVlidatorFilter) {
        this.customAuthenticationVlidatorFilter = customAuthenticationVlidatorFilter;
    }

    @Autowired
    public void setAuthenticationEntryPoint(CustomBasicAuthenticationEntryPoint authenticationEntryPoint){
        this.authenticationEntryPoint=authenticationEntryPoint;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        return security.httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                .and().addFilterBefore(customBasicAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(customAuthenticationVlidatorFilter,CustomBasicAuthenticationFilter.class)
                .authorizeHttpRequests().requestMatchers("/student/**").authenticated()
                .and()
                .exceptionHandling(ExceptionHandlingConfigurer ->
                        ExceptionHandlingConfigurer.authenticationEntryPoint(authenticationEntryPoint))
                .sessionManagement(session -> session.
                        sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(Customizer.withDefaults())
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
         corsConfiguration.addAllowedOriginPattern("/*");
         corsConfiguration.addAllowedHeader("Authorization");
         corsConfiguration.setAllowedMethods(List.of("GET","POST"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return urlBasedCorsConfigurationSource;


    }
}
