package com.pigatron.web.core.settings.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.web.core.api.View;
import com.pigatron.web.core.settings.Settings;
import com.pigatron.web.core.settings.SettingsService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "${url.public}/api/settings", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicSettingsController {

    private SettingsService settingsService;

    @Autowired
    public PublicSettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by id")
    @JsonView(View.Public.class)
    public Settings get(@RequestParam("id") String id) {
        return settingsService.findOne(id);
    }

}
