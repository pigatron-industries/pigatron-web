package com.pigatron.web.security.service;

import com.pigatron.web.core.service.AbstractRepositoryService;
import com.pigatron.web.security.entity.User;
import com.pigatron.web.security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecUserDetailsService extends AbstractRepositoryService<User> implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(SecUserDetailsService.class);

    public static final String ROLE_ADMIN = "ADMIN";

    @Autowired
    private UserRepository userRepository;

    public SecUserDetailsService() {
        super(User.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @EventListener
    public void setupRepositories(ContextRefreshedEvent event) {
        if(userRepository.findAll().isEmpty()) {
            logger.info("WARNING: Creating default admin user. Please change the username and password.");
            createAdminUser("admin", "password");
        }
    }

    public User createAdminUser(String username, String password) {
        String passwordHash = encodePassword(password);
        User user = new User(username, passwordHash, ROLE_ADMIN);
        userRepository.save(user);
        return user;
    }

    @Override
    public User save(User user) {
        validate(user);
        encodePassword(user);
        return super.save(user);
    }

    private void validate(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if(user.getId() == null && existingUser.isPresent()) {
            throw new RuntimeException("User with the same username already exists.");
        } else if (existingUser.isPresent() && !existingUser.get().getId().equals(user.getId())) {
            throw new RuntimeException("User with the same username already exists.");
        }
    }

    private void encodePassword(User user) {
        if(user.getId() != null) {
            User previousUser = findById(user.getId());
            if(!previousUser.getPassword().equals(user.getPassword())) {
                user.setPassword(encodePassword(user.getPassword()));
            }
        } else {
            user.setPassword(encodePassword(user.getPassword()));
        }
    }

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
