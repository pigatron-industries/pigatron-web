package com.pigatron.web.security.service;

import com.pigatron.web.core.service.AbstractRepositoryService;
import com.pigatron.web.security.entity.User;
import com.pigatron.web.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecUserDetailsService extends AbstractRepositoryService<User> implements UserDetailsService {

    public static final String ROLE_ADMIN = "ADMIN";

    private UserRepository userRepository;

    @Autowired
    public SecUserDetailsService(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

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
        String passwordHash = encodePassword(password);
        User user = new User(username, passwordHash, ROLE_ADMIN);
        userRepository.save(user);
        return user;
    }

    @Override
    public User save(User user) {
        if(user.getId() != null) {
            //check if password has changed and re-encode
            User previousUser = userRepository.findOne(user.getId());
            if(!previousUser.getPassword().equals(user.getPassword())) {
                user.setPassword(encodePassword(user.getPassword()));
            }
        } else {
            user.setPassword(encodePassword(user.getPassword()));
        }

        return super.save(user);
    }

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
