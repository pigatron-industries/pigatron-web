package com.pigatron.admin.service.security;


import com.pigatron.admin.domain.entity.user.User;
import com.pigatron.admin.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user = userRepository.findByUsername(token.getUsername());
        user.setTokenSeries(token.getSeries());
        user.setTokenValue(token.getTokenValue());
        user.setTokenDate(token.getDate());
        userRepository.save(user);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        User user = userRepository.findByTokenSeries(series);
        user.setTokenValue(tokenValue);
        user.setTokenDate(lastUsed);
        userRepository.save(user);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String tokenSeries) {
        User user = userRepository.findByTokenSeries(tokenSeries);
        if(user != null) {
            return new PersistentRememberMeToken(user.getUsername(), user.getTokenSeries(), user.getTokenValue(), user.getTokenDate());
        }
        return null;
    }

    @Override
    public void removeUserTokens(String username) {
        User user = userRepository.findByUsername(username);
        user.setTokenSeries(null);
        user.setTokenValue(null);
        user.setTokenDate(null);
        userRepository.save(user);
    }
}
