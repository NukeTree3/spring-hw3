package com.nuketree3.example.springhw2.service;

import com.nuketree3.example.springhw2.domain.User;
import com.nuketree3.example.springhw2.enums.Roles;
import com.nuketree3.example.springhw2.repositories.UserRepository;
import com.nuketree3.example.springhw2.userdetails.UserDetailsImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        String role = userRepository.getUserRole(user.getId());
        return UserDetailsImplementation.buildUserDetails(user, role);
    }

    public boolean createUser(User user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        userRepository.setRole(user.getId(), String.valueOf(Roles.ROLE_USER));

        return true;
    }
}
