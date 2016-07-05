package com.pigatron.web.core.settings;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface SettingsRepository extends MongoRepository<Settings, String> {
}
