package com.nuketree3.example.springhw2.userdetails;

import com.nuketree3.example.springhw2.domain.User;
import com.nuketree3.example.springhw2.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDetailsImplementation implements UserDetails {

    private long id;
    private String username;
    private String password;
    private String userRole;

    public static UserDetails buildUserDetails(User user, String userRole) {
        return new UserDetailsImplementation(
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            userRole
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return userRole.equals(String.valueOf(Roles.ROLE_USER)) || userRole.equals(String.valueOf(Roles.ROLE_ADMIN));
    }
}
