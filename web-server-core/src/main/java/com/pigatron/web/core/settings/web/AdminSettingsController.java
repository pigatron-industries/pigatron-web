package com.pigatron.web.core.settings.web;


import com.pigatron.web.core.api.AbstractWriteRestController;
import com.pigatron.web.core.settings.Settings;
import com.pigatron.web.core.settings.SettingsService;
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
@RequestMapping(value = "${url.admin}/api/settings", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminSettingsController extends AbstractWriteRestController<Settings> {

    @Autowired
    public AdminSettingsController(SettingsService settingsService) {
        super(settingsService);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all")
    public List<Settings> get() {
        return service.findAll(new Sort("group", "name"));
    }

}
