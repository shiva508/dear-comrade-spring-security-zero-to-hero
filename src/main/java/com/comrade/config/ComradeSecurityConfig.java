package com.comrade.config;

import com.comrade.config.entrypoint.ComradeAuthenticationEntrypoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ComradeSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(hsflc -> hsflc.defaultSuccessUrl("/api/v1/welcome", true));
        httpSecurity.authorizeHttpRequests(arm -> arm.anyRequest().authenticated());
        return httpSecurity.build();
    }


}
