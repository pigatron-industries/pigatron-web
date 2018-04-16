package com.pigatron.web.security.web;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.pigatron.web.core.api.AbstractWriteRestController;
import com.pigatron.web.security.entity.User;
import com.pigatron.web.security.repository.UserQueryBuilder;
import com.pigatron.web.security.service.SecUserDetailsService;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "${url.admin}/api/security/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminUserController extends AbstractWriteRestController<User> {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Query")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sortField", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sortDir", dataType = "string", paramType = "query", allowableValues = "ASC,DESC"),
            @ApiImplicitParam(name = "page", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "username", dataType = "string", paramType = "query")
    })
    public List<User> query(@ApiIgnore UserQueryBuilder query) {
        return service.query(query);
    }

}
