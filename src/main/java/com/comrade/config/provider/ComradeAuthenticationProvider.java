package com.comrade.config.provider;

import com.comrade.service.ComradeUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ComradeAuthenticationProvider implements AuthenticationProvider {

    private final ComradeUserDetailsService comradeUserDetailsService;

    public ComradeAuthenticationProvider(ComradeUserDetailsService comradeUserDetailsService) {
        this.comradeUserDetailsService = comradeUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        log.info("username = {}",username);
        log.info("password = {}",password);
        UserDetails userDetails = comradeUserDetailsService.loadUserByUsername(username);
        if (null != userDetails && comradeUserDetailsService.passwordEncoder().matches(password, userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        }else {
            throw  new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
