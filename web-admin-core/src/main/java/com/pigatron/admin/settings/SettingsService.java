package com.pigatron.admin.settings;


import com.pigatron.admin.service.AbstractRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService extends AbstractRepositoryService<Settings> {

    private SettingsRepository settingsRepository;

    @Autowired
    public SettingsService(SettingsRepository repository) {
        super(repository);
        this.settingsRepository = repository;
    }



}
