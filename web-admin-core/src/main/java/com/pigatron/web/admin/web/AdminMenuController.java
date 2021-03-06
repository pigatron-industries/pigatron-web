package com.pigatron.web.admin.web;

import com.pigatron.web.admin.menu.MenuItem;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "${url.admin}/api/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminMenuController {

    @Autowired
    private MenuItem adminMenu;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all admin menu items")
    public MenuItem getAdminMenuFlattened() {
        return adminMenu;
    }

}
