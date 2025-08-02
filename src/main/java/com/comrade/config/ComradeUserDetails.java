package com.comrade.config;

import com.comrade.entity.ComradeUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class ComradeUserDetails implements UserDetails {

    private final ComradeUserEntity comradeUserEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(comradeUserEntity::getAuthority);
    }

    @Override
    public String getPassword() {
        return comradeUserEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return comradeUserEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
