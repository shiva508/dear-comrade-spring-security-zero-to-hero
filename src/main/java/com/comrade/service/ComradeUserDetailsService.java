package com.comrade.service;

import com.comrade.config.ComradeUserDetails;
//import com.comrade.repository.ComradeUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ComradeUserDetailsService implements UserDetailsService {

//    private final ComradeUserRepository comradeUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
       return null;
    }
}
