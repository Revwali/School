package com.example.Micro_Resource.CustomAuthenticationPackage;


import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

public class CustomAuthenticationToken extends AbstractAuthenticationToken{

    private String token = null;

    public CustomAuthenticationToken(Collection<? extends GrantedAuthority> authorities, String token) {
        super(authorities);
        this.token = token;
        super.setAuthenticated(true);
    }

    public CustomAuthenticationToken(String token) {
        super(null);
        this.token = token;
        super.setAuthenticated(false);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return super.implies(subject);
    }
}
