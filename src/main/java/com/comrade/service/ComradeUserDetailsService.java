package com.comrade.service;

import com.comrade.config.ComradeUserDetails;
import com.comrade.entity.ComradeUserEntity;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ComradeUserDetailsService implements UserDetailsService {

    List<ComradeUserEntity> comradeUserEntities;
    @Override
    public UserDetails loadUserByUsername(String username) {

       return comradeUserEntities.stream()
                .filter(comradeUserEntity -> comradeUserEntity.getUsername().equals(username))
                .map(ComradeUserDetails::new).findFirst()
               .orElseThrow(()-> new  UsernameNotFoundException("User not found"));
    }


    @PostConstruct
    public void init(){
        comradeUserEntities = new ArrayList<>();
        comradeUserEntities.add(ComradeUserEntity.builder().username("shiva").password("shiva").authority("read").build());
        comradeUserEntities.add(ComradeUserEntity.builder().username("dasari").password("dasari").authority("read").build());
    }
}
