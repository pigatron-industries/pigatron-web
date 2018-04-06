package com.pigatron.web.security.web;

import com.pigatron.web.security.service.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/security/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicUserController {

    private SecUserDetailsService userDetailsService;

    @Autowired
    public PublicUserController(SecUserDetailsService secUserDetailsService) {
        this.userDetailsService = secUserDetailsService;
    }

    @RequestMapping()
    public Principal user(Principal user) {
        return user;
    }

}
