package com.example.event.entity;

//import org.springframework.security.core.GrantedAuthority;

public enum Roles  {
    ROLE_USER, ROLE_ADMIN;
    public String getAuthority() {
        return name();
    }
}
