package com.comrade.service;

import com.comrade.config.ComradeUserDetails;
//import com.comrade.repository.ComradeUserRepository;
import com.comrade.entity.ComradeUserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ComradeUserDetailsService implements UserDetailsService {


    private final PasswordEncoder bCryptPasswordEncoder;

    public ComradeUserDetailsService(@Autowired @Qualifier("bCryptPasswordEncoder") PasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //    private final ComradeUserRepository comradeUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        ComradeUserEntity comradeUserEntity = ComradeUserEntity.builder()
                .username("shiva")
                .password(bCryptPasswordEncoder.encode("dasari"))
                .enabled(true)
                .build();
        return new ComradeUserDetails(comradeUserEntity);
    }

    public PasswordEncoder passwordEncoder(){
        return bCryptPasswordEncoder;
    }
}
