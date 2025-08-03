package com.comrade.config;

import com.comrade.config.filters.ApiKeyAuthenticationFilter;
import com.comrade.config.filters.AuthenticationLoggingFilter;
import com.comrade.config.filters.ComradeOncePerRequestFilter;
import com.comrade.config.filters.RequestValidationFilter;
import com.comrade.service.ComradeUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class ComradeSecurityConfig {

    private final ComradeUserDetailsService comradeUserDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.addFilterBefore(new ComradeOncePerRequestFilter(), BasicAuthenticationFilter.class);
        httpSecurity.addFilterAt(new ApiKeyAuthenticationFilter(), BasicAuthenticationFilter.class);
        httpSecurity.userDetailsService(comradeUserDetailsService);
        httpSecurity.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(amrmr ->amrmr.anyRequest().permitAll());
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
