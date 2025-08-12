package com.comrade.config;

import com.comrade.config.entrypoint.ComradeAuthenticationEntrypoint;
import com.comrade.config.handler.ComradeAuthenticationFailureHandler;
import com.comrade.config.handler.ComradeAuthenticationSuccessHandler;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class ComradeSecurityConfig {

    private final ComradeAuthenticationSuccessHandler comradeAuthenticationSuccessHandler;
    private final ComradeAuthenticationFailureHandler comradeAuthenticationFailureHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(hsflc -> {
            hsflc.successHandler(comradeAuthenticationSuccessHandler)
                    .failureHandler(comradeAuthenticationFailureHandler);
        });
        httpSecurity.authorizeHttpRequests(arm -> arm.anyRequest().authenticated());
        return httpSecurity.build();
    }


}
