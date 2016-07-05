package com.pigatron.web.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pigatron.web.core.settings.Settings;
import com.pigatron.web.core.settings.SettingsMixIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminEntityConfig {

    @Autowired
    public void objectMapper(ObjectMapper objectMapper) {
        objectMapper.addMixIn(Settings.class, SettingsMixIn.class);
    }

}
