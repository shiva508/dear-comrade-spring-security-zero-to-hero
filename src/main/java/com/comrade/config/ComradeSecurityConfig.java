package com.comrade.config;

import com.comrade.config.filters.ApiKeyAuthenticationFilter;
import com.comrade.config.filters.AuthenticationLoggingFilter;
import com.comrade.config.filters.ComradeOncePerRequestFilter;
import com.comrade.config.filters.RequestValidationFilter;
import com.comrade.config.provider.ComradeAuthenticationProvider;
import com.comrade.service.ComradeUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class ComradeSecurityConfig {

    private final ComradeAuthenticationProvider comradeAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.authenticationProvider(comradeAuthenticationProvider);
        httpSecurity.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(amrmr ->amrmr.anyRequest().permitAll());
        return httpSecurity.build();
    }


}
