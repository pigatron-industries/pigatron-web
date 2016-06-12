package com.pigatron.admin.settings;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.pigatron.admin.settings.website.WebSiteSettings;

@JsonSubTypes({
        @JsonSubTypes.Type(name = "WebSiteSettings", value = WebSiteSettings.class)
})
public class SettingsMixIn {
}
