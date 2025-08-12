package com.comrade.config.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Component
public class ComradeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        Optional<? extends GrantedAuthority> roleAdmin = authorities.stream().filter(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))
                .findFirst();
        if (roleAdmin.isPresent()) {
            response.setHeader("message", "Welcome");
            response.sendRedirect("/api/v1/welcome");
        }else {
            response.setHeader("message", "Welcome to the world");
            response.sendRedirect("/api/v1/hello");
        }
    }
}
