    package com.example.Micro_Resource.CustomAuthenticationManager;

    import com.example.Micro_Resource.CustomAuthenticationProvider.CustomAuthenticationProvider;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.AuthenticationProvider;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.AuthenticationException;
    import org.springframework.stereotype.Component;

    import java.util.List;

    @Component
    public class CustomAuthenticationManager implements AuthenticationManager {


        private List<AuthenticationProvider> authenticationProvider;

        @Autowired
        public void setAuthenticationProvider(List<AuthenticationProvider> authenticationProvider) {
            this.authenticationProvider = authenticationProvider;
        }



        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {

            for(AuthenticationProvider provider :authenticationProvider ) {
                if (provider.supports(authentication.getClass())) {
                    return provider.authenticate(authentication);

                }
            }
                return null;

        }
    }
