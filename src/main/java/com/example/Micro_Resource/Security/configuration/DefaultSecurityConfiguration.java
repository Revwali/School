package com.example.Micro_Resource.Security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class DefaultSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
       return security
               .authorizeHttpRequests().anyRequest().permitAll().and()
               .cors().disable().csrf().disable()

        .build();
    }
   /* @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
         corsConfiguration.addAllowedOriginPattern("/*");
         corsConfiguration.addAllowedHeader("Authorization");
         corsConfiguration.setAllowedMethods(List.of("GET","POST"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return urlBasedCorsConfigurationSource;


    }*/
}
