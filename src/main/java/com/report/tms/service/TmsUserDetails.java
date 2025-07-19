package com.report.tms.service;

import com.report.tms.model.UserInformation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

public class TmsUserDetails implements UserDetails {

    //this is translator between database and spring security
    //it takes your userdata and make it looks like spring security
    private final UserInformation u;

    public TmsUserDetails(UserInformation u){
        this.u = u;
    }

    @Override
    public String getUsername() {
        return u.getUsername();
    }

    @Override
    public String getPassword() {
        return u.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(u.getRole()));
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
