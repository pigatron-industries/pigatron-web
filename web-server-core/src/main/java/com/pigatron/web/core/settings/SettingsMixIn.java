package com.pigatron.web.core.settings;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.pigatron.web.core.settings.website.WebSiteSettings;

@JsonSubTypes({
        @JsonSubTypes.Type(name = "WebSiteSettings", value = WebSiteSettings.class)
})
public class SettingsMixIn {
}
