package com.pigatron.shop.service;

import com.pigatron.shop.domain.entity.user.User;
import com.pigatron.shop.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecUserDetailsService implements UserDetailsService {

    public static final String ROLE_ADMIN = "ADMIN";

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        else {
            return user;
        }
    }

    public User createAdminUser(String username, String password) {
        String passwordHash = new BCryptPasswordEncoder().encode(password);
        User user = new User(username, passwordHash, ROLE_ADMIN);
        userRepository.save(user);
        return user;
    }

}
