package com.apiit.eeashoppingapplication.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.stream.Collectors;

public class AuthUserDetails extends User implements UserDetails {


    public AuthUserDetails(final  User user){
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return getRole().stream().map(type -> new SimpleGrantedAuthority("TYPE_"+type.getRole())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
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
