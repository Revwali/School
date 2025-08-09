package com.example.Micro_Resource.CustomAuthentictionFilter;

import com.example.Micro_Resource.CustomAuthenticationPackage.CustomAuthenticationToken;
import com.example.Micro_Resource.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CustomBasicAuthenticationFilter extends OncePerRequestFilter {


    private JWTUtil jwtUtil = JWTUtil.getInstance();
    private AuthenticationManager authenticationManager;
    private BasicAuthenticationConverter authenticationConverter = new BasicAuthenticationConverter();

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if ((request.getHeader("Authorization").contains("Bearer"))) {
            filterChain.doFilter(request, response);
        } else {
            Authentication authenticationRequest = authenticationConverter.convert(request); // usernameauthtoken is returned
            // check null here
            // authenticationRequest.get
         //   CustomAuthenticationToken authentication = new CustomAuthenticationToken(null,authenticationRequest.getPrincipal(), authenticationRequest.getCredentials(), authenticationRequest.getAuthorities());
            //   Authentication authRequest = this.authenticationConverter.convert(request); // return is username authtoken
            Authentication authResult = authenticationManager.authenticate(authenticationRequest);
            String token = jwtUtil.generateToken(authResult.getName(), authResult.getAuthorities().toString());
            response.setHeader("Authorization", "Bearer " + token);
            SecurityContextHolder.getContext().setAuthentication(authResult);
            filterChain.doFilter(request, response);
        }
    }
}
