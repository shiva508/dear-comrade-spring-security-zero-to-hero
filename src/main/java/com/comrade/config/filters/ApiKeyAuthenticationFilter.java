package com.comrade.config.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Slf4j
public class ApiKeyAuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        String apiKey = httpServletRequest.getHeader("API-KEY");
        log.info("API_KEY= {}",apiKey);
        if (StringUtils.isNotBlank(apiKey) && apiKey.equals("DEAR_COMRADE")){
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
