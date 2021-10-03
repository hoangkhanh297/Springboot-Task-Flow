package com.khanhhoang.helllo.authen;

import com.khanhhoang.helllo.model.RoleEntity;
import com.khanhhoang.helllo.model.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class Authentications implements Authentication {
    private final UserEntity user;
    private final List<RoleEntity> roles;
    private boolean authenticate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (var role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }


    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return user.getUserId();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticate;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        authenticate = b;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }
}
