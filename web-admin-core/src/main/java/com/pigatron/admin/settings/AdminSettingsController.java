package com.pigatron.admin.settings;


import com.pigatron.admin.api.AbstractWriteRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.admin}/api/settings", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminSettingsController extends AbstractWriteRestController<Settings> {


    @Autowired
    public AdminSettingsController(SettingsService settingsService) {
        super(settingsService);
    }
}
