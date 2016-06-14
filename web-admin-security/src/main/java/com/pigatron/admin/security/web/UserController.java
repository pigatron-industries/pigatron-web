package com.pigatron.admin.security.web;

import com.pigatron.admin.api.AbstractWriteRestController;
import com.pigatron.admin.security.SecUserDetailsService;
import com.pigatron.admin.security.entity.User;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
