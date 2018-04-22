package com.pigatron.web.security.repository;


import com.pigatron.web.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserTokenRepository implements PersistentTokenRepository {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        User user = userRepository.findByUsername(token.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(token.getUsername()));
        user.setTokenSeries(token.getSeries());
        user.setTokenValue(token.getTokenValue());
        user.setTokenDate(token.getDate());
        userRepository.save(user);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        User user = userRepository.findByTokenSeries(series)
                .orElseThrow(() -> new UsernameNotFoundException(series));
        user.setTokenValue(tokenValue);
        user.setTokenDate(lastUsed);
        userRepository.save(user);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String tokenSeries) {
        return userRepository.findByTokenSeries(tokenSeries)
                .map(user1 -> new PersistentRememberMeToken(user1.getUsername(), user1.getTokenSeries(), user1.getTokenValue(), user1.getTokenDate()))
                .orElse(null);
    }

    @Override
    public void removeUserTokens(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        user.setTokenSeries(null);
        user.setTokenValue(null);
        user.setTokenDate(null);
        userRepository.save(user);
    }
}
