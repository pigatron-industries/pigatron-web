package com.pigatron.web.core.settings;

import com.pigatron.web.core.service.AbstractRepositoryService;
import org.springframework.stereotype.Service;

@Service
public class SettingsService extends AbstractRepositoryService<Settings> {

    public SettingsService() {
        super(Settings.class);
    }
}
