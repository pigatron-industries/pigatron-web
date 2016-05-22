package com.pigatron.admin.settings;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface SettingsRepository extends MongoRepository<Settings, String> {
}
