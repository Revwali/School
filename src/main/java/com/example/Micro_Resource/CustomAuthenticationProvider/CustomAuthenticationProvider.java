package com.example.Micro_Resource.CustomAuthenticationProvider;


import com.example.Micro_Resource.CustomAuthenticationPackage.CustomAuthenticationToken;
import com.example.Micro_Resource.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Order('1')
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Override
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        super.setUserDetailsService(userDetailsService);
    }

    @Autowired
    @Override
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        super.setPasswordEncoder(passwordEncoder);
    }

    /*@Autowired
    public void setJwtUtil(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }*/

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // put it in try
        try {
            Authentication resultAuthentication = super.authenticate(authentication);
            // OTP implementation logic - once done
            // plus once OTP is used set scope manually
            return resultAuthentication;
        } catch (Exception e) {
           // implement exceoption handling
            System.out.println("something went wrong "+e.getMessage());
            return authentication;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return  UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication) ;

    }
}
