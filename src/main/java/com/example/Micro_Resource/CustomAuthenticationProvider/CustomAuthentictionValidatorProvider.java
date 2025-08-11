package com.example.Micro_Resource.CustomAuthenticationProvider;


import com.example.Micro_Resource.CustomAuthenticationPackage.CustomAuthenticationToken;
import com.example.Micro_Resource.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order('2')
public class CustomAuthentictionValidatorProvider implements AuthenticationProvider {

    private JWTUtil jwtUtil = JWTUtil.getInstance();;




    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String token = ( (CustomAuthenticationToken) authentication).getToken();
      //  try {
            Claims claims = jwtUtil.validateAndExtractUsername(token);
            String scope = claims.getSubject();
            if (scope == null) {
                throw new AccountExpiredException("token invalid");
            } else
                return new CustomAuthenticationToken(claims.getSubject(), List.of(new SimpleGrantedAuthority(claims.get("ROLE_").toString())), token);
       /* } catch (Exception e) {
            // implement exceoption handling
            System.out.println("something went wrong "+e.getMessage());
            return authentication;
        }*/
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
