package com.comrade.config.entrypoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class ComradeAuthenticationEntrypoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authException) throws IOException, ServletException {
        httpServletResponse
                .addHeader("message", "welcome to the world");
        httpServletResponse
                .sendError(HttpStatus.UNAUTHORIZED.value());
    }
}
