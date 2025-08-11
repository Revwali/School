package com.example.Micro_Resource.CustomAuthentictionFilter;

import com.example.Micro_Resource.CustomAuthenticationPackage.CustomAuthenticationToken;
import com.example.Micro_Resource.util.JWTUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class CustomAuthenticationVlidatorFilter extends OncePerRequestFilter {

    private JWTUtil jwtUtil = JWTUtil.getInstance();
    private AuthenticationManager authenticationManager;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if ( request.getServletPath().equals("/generate-token") || request.getServletPath().equals("/refresh_token")) {
            filterChain.doFilter(request, response);
        }
        else {
            String bearerToken = request.getHeader("Authorization");
            String token = extractToken(bearerToken);
            if (token != null) {
                CustomAuthenticationToken authenticationToken = new CustomAuthenticationToken(token);
                Authentication authentication = authenticationManager.authenticate(authenticationToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);

            }
        }

    }

    public String extractToken(String bearerToken){
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;

    }
}
