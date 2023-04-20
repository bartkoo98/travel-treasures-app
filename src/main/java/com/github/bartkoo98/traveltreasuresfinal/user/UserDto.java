package com.github.bartkoo98.traveltreasuresfinal.user;
import java.util.HashSet;
import java.util.Set;

public class UserDto {
    private String email;
    private String password;
    private Set<String> roles;

    public UserDto(String email, String password, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<String> roles) {
        this.roles = roles;
    }
}
