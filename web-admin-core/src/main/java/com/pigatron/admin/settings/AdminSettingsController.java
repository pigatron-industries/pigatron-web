package com.pigatron.admin.settings;


import com.pigatron.admin.api.AbstractWriteRestController;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
