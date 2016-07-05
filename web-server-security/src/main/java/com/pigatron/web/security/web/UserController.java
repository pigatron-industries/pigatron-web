package com.pigatron.web.security.web;

import com.pigatron.web.core.api.AbstractWriteRestController;
import com.pigatron.web.security.entity.User;
import com.pigatron.web.security.service.SecUserDetailsService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${url.admin}/api/security/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends AbstractWriteRestController<User> {

    private SecUserDetailsService userDetailsService;

    @Autowired
    public UserController(SecUserDetailsService secUserDetailsService) {
        super(secUserDetailsService);
        this.userDetailsService = secUserDetailsService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all")
    public List<User> query() {
        return userDetailsService.findAll(new Sort("username"));
    }

}
