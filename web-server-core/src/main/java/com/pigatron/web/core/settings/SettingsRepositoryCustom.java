package com.pigatron.web.core.settings;

import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


public interface SettingsRepositoryCustom {
    List<Settings> query(Query query);
}
